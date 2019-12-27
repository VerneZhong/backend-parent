package com.zxb.meetingfilm.user.controller.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BaseRequestVO;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:51
 */
@Data
public class LoginReqVO extends BaseRequestVO {

    private String username;
    private String password;

    @Override
    public void checkParam() throws CommonServiceException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new CommonServiceException(404, "username or password can not be empty");
        }
    }
}
