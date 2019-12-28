package com.zxb.meetingfilm.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsReqVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsRespVO;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2019-12-28 10:29
 */
public interface HallServiceAPI {

    IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO);

    void saveHall(HallSavedReqVO hallSavedReqVO);
}
