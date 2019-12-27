package com.zxb.meetingfilm.user.test;

import com.zxb.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.zxb.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 16:41
 */
@SpringBootTest
public class UsetTest  {

    @Autowired
    private MoocBackendUserTMapper userTMapper;

    @Test
    public void testUserList() {
        List<MoocBackendUserT> userTS = userTMapper.selectList(null);
        System.out.println(userTS);
    }
}
