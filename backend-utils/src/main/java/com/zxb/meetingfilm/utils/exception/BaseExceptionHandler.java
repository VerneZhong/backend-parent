package com.zxb.meetingfilm.utils.exception;

import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础异常处理类
 *
 * @author Mr.zxb
 * @date 2019-12-26 17:17
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(CommonServiceException.class)
    public BaseResponseVO serviceExceptionHandler(HttpServletRequest request, CommonServiceException e) {
        log.error("CommonServiceException, code: {}, message: {}", e.getCode(), e.getMessage());
        return BaseResponseVO.serviceException(e);
    }
}
