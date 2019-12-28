package com.zxb.meetingfilm.hall.controller.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BaseRequestVO;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 10:39
 */
@Data
public class HallSavedReqVO extends BaseRequestVO {
    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
