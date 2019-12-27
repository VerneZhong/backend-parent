package com.zxb.meetingfilm.user.service;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2019-12-26 17:24
 */
public interface UserServiceAPI {

    String checkUserLogin(String username, String password) throws CommonServiceException;
}
