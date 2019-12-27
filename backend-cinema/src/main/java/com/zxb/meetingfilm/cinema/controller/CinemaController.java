package com.zxb.meetingfilm.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespPageVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.zxb.meetingfilm.cinema.service.CinemaServiceAPI;
import com.zxb.meetingfilm.utils.vo.BasePageVO;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public BaseResponseVO describeCinemas(@RequestBody BasePageVO vo) {

        IPage<DescribeCinemaRespVO> page = cinemaServiceAPI.describeCinemas(vo);

        DescribeCinemaRespPageVO pageVO = new DescribeCinemaRespPageVO(page);
        return BaseResponseVO.success(pageVO);
    }
}
