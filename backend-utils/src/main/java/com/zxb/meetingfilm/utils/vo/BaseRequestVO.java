package com.zxb.meetingfilm.utils.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:52
 */
public abstract class BaseRequestVO {

    /**
     * 请求VO参数校验
     * @throws CommonServiceException
     */
    public abstract void checkParam() throws CommonServiceException;
}
