package com.zxb.meetingfilm.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxb.meetingfilm.api.film.vo.DescribeFilmRespVO;
import com.zxb.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.zxb.meetingfilm.film.dao.entity.MoocFilmT;

import java.util.Optional;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author Mr.zxb
 * @since 2019-12-27
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

    IPage<DescribeFilmsRespVO> describeFilms(Page<DescribeFilmsRespVO> page);

    Optional<DescribeFilmRespVO> describeFilmById(String filmId);

}
