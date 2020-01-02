package com.zxb.meetingfilm.film.controller;

import com.zxb.meetingfilm.film.controller.vo.LoginReqVO;
import com.zxb.meetingfilm.film.service.UserServiceAPI;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.properties.JwtTokenUtil;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户 Controller
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    /**
     * 登陆接口
     *
     * @param reqVO
     * @return
     * @throws CommonServiceException
     */
    @PostMapping("/login")
    public BaseResponseVO login(@RequestBody LoginReqVO reqVO) throws CommonServiceException {

        // 参数校验
        reqVO.checkParam();

        String userId = userServiceAPI.checkUserLogin(reqVO.getUsername(), reqVO.getPassword());

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);
        Map<String, Object> map = new HashMap<>();
        map.put("randomKey", randomKey);
        map.put("token", token);
        return BaseResponseVO.success(map);
    }
}
