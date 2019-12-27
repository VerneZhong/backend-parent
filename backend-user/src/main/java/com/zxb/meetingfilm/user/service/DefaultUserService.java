package com.zxb.meetingfilm.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxb.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.zxb.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 17:25
 */
@Service
public class DefaultUserService implements UserServiceAPI {

    @Autowired
    private MoocBackendUserTMapper userTMapper;

    @Override
    public String checkUserLogin(String username, String password) throws CommonServiceException {
        QueryWrapper queryWrapper = new QueryWrapper<MoocBackendUserT>();
        queryWrapper.eq("user_name", username);

        MoocBackendUserT userT = userTMapper.selectOne(queryWrapper);
        if (userT != null) {
            String encrypt = MD5Util.encrypt(password);
            if (!encrypt.equals(userT.getUserPwd())) {
                throw new CommonServiceException(500, "用户密码输入有误");
            }
            return userT.getUuid().toString();
        } else {
            throw new CommonServiceException(404, "用户名输入有误");
        }
    }
}
