package com.zxb.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BasePageVO;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 17:04
 */
public interface CinemaServiceAPI {

    void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException;


    IPage<DescribeCinemaRespVO> describeCinemas(BasePageVO vo);
}
