package com.zxb.meetingfilm.hall.feign;

import com.zxb.meetingfilm.api.film.FilmFeignServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2019-12-31 18:36
 */
@FeignClient(name = "film", path = "/films")
public interface FilmServiceAPI extends FilmFeignServiceAPI {

}
