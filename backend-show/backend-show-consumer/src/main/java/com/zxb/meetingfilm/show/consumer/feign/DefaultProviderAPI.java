package com.zxb.meetingfilm.show.consumer.feign;

import com.zxb.meetingfilm.show.consumer.feign.vo.UserModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-31 15:08
 */
@Service
//@Primary
public class DefaultProviderAPI implements ProviderAPI {
    @Override
    public String invokeProviderService(String message) {
        return null;
    }

//    @Override
//    public String prividerPost(String author, String providerId, UserModel userModel) {
//        return null;
//    }
}
