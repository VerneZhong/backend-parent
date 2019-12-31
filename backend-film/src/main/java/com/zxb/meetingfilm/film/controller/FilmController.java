package com.zxb.meetingfilm.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.film.controller.vo.*;
import com.zxb.meetingfilm.film.service.FilmServiceAPI;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BasePageVO;
import com.zxb.meetingfilm.utils.vo.BaseResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 11:09
 */
@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmServiceAPI filmServiceAPI;

    /**
     * 演员列表信息
     * @param vo
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("/actors")
    public BaseResponseVO describeActors(BasePageVO vo) throws CommonServiceException {

        vo.checkParam();

        IPage<DescribeActorsRespVO> page = filmServiceAPI.describeActors(vo.getNowPage(), vo.getPageSize());

        DescribeActorsRespPageVO pageVO = new DescribeActorsRespPageVO(page);
        return BaseResponseVO.success(pageVO);
    }

    /**
     * 电影列表信息
     * @param vo
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("")
    public BaseResponseVO describeFilms(@RequestBody BasePageVO vo) throws CommonServiceException {

        vo.checkParam();

        IPage<DescribeFilmsRespVO> page = filmServiceAPI.describeFilms(vo.getNowPage(), vo.getPageSize());

        DescribeFilmsRespPageVO pageVO = new DescribeFilmsRespPageVO(page);
        return BaseResponseVO.success(pageVO);
    }

    /**
     * 根据电影编号获取电影信息
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("/{filmId}")
    public BaseResponseVO describeFilmById(@PathVariable String filmId) throws CommonServiceException {
        Optional<DescribeFilmRespVO> voOptional = filmServiceAPI.describeFilmById(filmId);
        return voOptional.map(BaseResponseVO::success).orElse(BaseResponseVO.success());
    }

    /**
     * 添加影片
     * @param filmSavedReqVO
     * @return
     */
    @PostMapping("/film:add")
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) {
        filmServiceAPI.saveFilmInfo(filmSavedReqVO);
        return BaseResponseVO.success();
    }
}
