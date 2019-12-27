package com.zxb.meetingfilm.cinema.controller.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.utils.vo.BaseResponsePageVO;
import lombok.Data;

import java.util.List;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 17:10
 */
@Data
public class DescribeCinemaRespPageVO extends BaseResponsePageVO<DescribeCinemaRespVO> {

    private List<DescribeCinemaRespVO> cinemas;

    public DescribeCinemaRespPageVO(IPage<DescribeCinemaRespVO> page) {
        super(page);
        this.cinemas = page.getRecords();
    }
}
