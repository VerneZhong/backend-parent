package com.zxb.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxb.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.zxb.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.zxb.meetingfilm.cinema.dao.entity.MoocCinemaT;
import com.zxb.meetingfilm.cinema.dao.mapper.MoocCinemaTMapper;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import com.zxb.meetingfilm.utils.vo.BasePageVO;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 17:12
 */
@Service
public class DefaultCinemaServiceAPI implements CinemaServiceAPI {

    @Autowired
    private MoocCinemaTMapper cinemaTMapper;

    private static DescribeCinemaRespVO transform(MoocCinemaT cinema) {
        DescribeCinemaRespVO cinemaRespVO = new DescribeCinemaRespVO();
        cinemaRespVO.setBrandId(cinema.getBrandId().toString());
        cinemaRespVO.setAreaId(cinema.getAreaId().toString());
        cinemaRespVO.setHallTypeIds(cinema.getHallIds());
        cinemaRespVO.setCinemaName(cinema.getCinemaName());
        cinemaRespVO.setCinemaAddress(cinema.getCinemaAddress());
        cinemaRespVO.setCinemaTele(cinema.getCinemaPhone());
        cinemaRespVO.setCinemaImgAddress(cinema.getImgAddress());
        cinemaRespVO.setCinemaPrice(cinema.getMinimumPrice().toString());

        return cinemaRespVO;
    }

    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {
        MoocCinemaT moocCinemaT = new MoocCinemaT();
        moocCinemaT.setCinemaName(reqVO.getCinemaName());
        moocCinemaT.setCinemaPhone(reqVO.getCinemaTele());
        moocCinemaT.setBrandId(Integer.parseInt(reqVO.getBrandId()));
        moocCinemaT.setAreaId(Integer.parseInt(reqVO.getAreaId()));
        moocCinemaT.setHallIds(reqVO.getHallTypeIds());
        moocCinemaT.setImgAddress(reqVO.getCinemaImgAddress());
        moocCinemaT.setCinemaAddress(reqVO.getCinemaAddress());
        moocCinemaT.setMinimumPrice(Integer.valueOf(reqVO.getCinemaPrice()));

        cinemaTMapper.insert(moocCinemaT);
    }

    @Override
    public IPage<DescribeCinemaRespVO> describeCinemas(BasePageVO vo) {
// 查询实体对象，然后与表现层对象进行交互
        // TODO 提示
        Page<MoocCinemaT> page = new Page<>(vo.getNowPage(), vo.getPageSize());
        IPage<MoocCinemaT> moocCinemaTIPage = cinemaTMapper.selectPage(page, null);

        List<DescribeCinemaRespVO> describeCinemaRespVOS = moocCinemaTIPage.getRecords().stream()
                .map(DefaultCinemaServiceAPI::transform).collect(Collectors.toList());

        IPage<DescribeCinemaRespVO> respVOIPage = new Page<>();

        BeanUtils.copyProperties(moocCinemaTIPage, respVOIPage);
        respVOIPage.setRecords(describeCinemaRespVOS);
        return respVOIPage;
    }
}
