package com.zxb.meetingfilm.hall.controller.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BasePageVO;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 10:31
 */
@Data
public class HallsReqVO extends BasePageVO {

    private String cinemaId;

    @Override
    public void checkParam() throws CommonServiceException {
        super.checkParam();
    }
}
