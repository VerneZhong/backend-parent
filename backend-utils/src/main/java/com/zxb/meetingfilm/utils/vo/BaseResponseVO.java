package com.zxb.meetingfilm.utils.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 17:00
 */
@Data
public class BaseResponseVO<T> {

    private Integer code;
    private String message;
    private T data;

    private BaseResponseVO() {

    }

    public static BaseResponseVO success() {
        BaseResponseVO baseResponseVO = new BaseResponseVO<>();
        baseResponseVO.setCode(200);
        baseResponseVO.setMessage("请求成功");
        return baseResponseVO;
    }

    public static <T> BaseResponseVO success(T data) {
        BaseResponseVO baseResponseVO = new BaseResponseVO<>();
        baseResponseVO.setCode(200);
        baseResponseVO.setData(data);
        baseResponseVO.setMessage("请求成功");
        return baseResponseVO;
    }

    /**
     * 出现异常返回
     * @param ex
     * @return
     */
    public static BaseResponseVO serviceException(CommonServiceException ex) {
        BaseResponseVO baseResponseVO = new BaseResponseVO<>();
        baseResponseVO.setCode(ex.getCode());
        baseResponseVO.setMessage(ex.getMessage());
        return baseResponseVO;
    }
}
