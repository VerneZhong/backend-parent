package com.zxb.meetingfilm.film.controller.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.utils.vo.BaseResponsePageVO;
import lombok.Data;

import java.util.List;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 12:09
 */
@Data
public class DescribeActorsRespPageVO extends BaseResponsePageVO<DescribeActorsRespVO> {

    private List<DescribeActorsRespVO> actors;

    public DescribeActorsRespPageVO(IPage<DescribeActorsRespVO> page) {
        super(page);
        this.actors = page.getRecords();
    }
}
