package com.zxb.meetingfilm.cinema.controller.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BaseRequestVO;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 17:03
 */
@Data
public class CinemaSavedReqVO extends BaseRequestVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
