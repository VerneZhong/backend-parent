package com.zxb.meetingfilm.hall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsReqVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsRespPageVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsRespVO;
import com.zxb.meetingfilm.hall.service.HallServiceAPI;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 10:26
 */
@RestController
@RequestMapping("/halls")
public class HallController {

    @Autowired
    private HallServiceAPI serviceAPI;

    @GetMapping("")
    public BaseResponseVO describeHalls(HallsReqVO hallsReqVO) throws CommonServiceException {

        hallsReqVO.checkParam();

        IPage<HallsRespVO> hallsRespVOIPage = serviceAPI.describeHalls(hallsReqVO);

        return BaseResponseVO.success(new HallsRespPageVO(hallsRespVOIPage));
    }

    @PostMapping("/hall:add")
    public BaseResponseVO savedHalls(@RequestBody HallSavedReqVO hallSavedReqVO) throws CommonServiceException {
        hallSavedReqVO.checkParam();
        serviceAPI.saveHall(hallSavedReqVO);
        return BaseResponseVO.success();
    }
}
