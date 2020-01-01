package com.zxb.meetingfilm.api.film;

import com.zxb.meetingfilm.api.film.vo.DescribeFilmRespVO;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2020-01-01 14:22
 */
public interface FilmFeignServiceAPI {

    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    BaseResponseVO<DescribeFilmRespVO> describeFilmById(@PathVariable String filmId) throws CommonServiceException;
}
