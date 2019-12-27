package com.zxb.meetingfilm.utils.exception;

import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:54
 */
@Data
public class CommonServiceException extends RuntimeException {

    private Integer code;
    private String message;

    public CommonServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
