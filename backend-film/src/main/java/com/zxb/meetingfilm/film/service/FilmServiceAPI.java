package com.zxb.meetingfilm.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.zxb.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.zxb.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.zxb.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;

import java.util.Optional;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 12:18
 */
public interface FilmServiceAPI {

    IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException;

    IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException;

    Optional<DescribeFilmRespVO> describeFilmById(String filmId) throws CommonServiceException;

    void saveFilmInfo(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException;
}
