package com.zxb.meetingfilm.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zxb.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespPageVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.zxb.meetingfilm.cinema.service.CinemaServiceAPI;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BasePageVO;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 16:41
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaServiceAPI cinemaServiceAPI;

    @PostMapping("/cinema:add")
    public BaseResponseVO saveCinema(@RequestBody CinemaSavedReqVO reqVO) {

        reqVO.checkParam();

        cinemaServiceAPI.saveCinema(reqVO);

        return BaseResponseVO.success();
    }

    /**
     * Hystrix 降级处理
     * @param vo
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")},
            ignoreExceptions = {CommonServiceException.class})
    @GetMapping("")
    public BaseResponseVO describeCinemas(BasePageVO vo) {

        IPage<DescribeCinemaRespVO> page = cinemaServiceAPI.describeCinemas(vo);

        // 触发降级
        if (vo.getNowPage() > 10000) {
            throw new CommonServiceException(400, "nowPage 太大了，不支持处理");
//            try {
//                Thread.sleep(2000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        DescribeCinemaRespPageVO pageVO = new DescribeCinemaRespPageVO(page);
        return BaseResponseVO.success(pageVO);
    }

    /**
     * fallback方法
     * Hystrix fallback是业务处理的兜底方案，尽可能保证这个兜底方案一定能成功
     *
     * @param vo
     * @return
     */
    public BaseResponseVO fallbackMethod(BasePageVO vo) {

//        Map<String, String> map = Maps.newHashMap("code", "500");
//        map.put("message", "请求处理降级返回");

        // 返回一定是成功，或者业务处理失败
        return BaseResponseVO.success();
    }
}
