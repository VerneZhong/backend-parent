package com.zxb.meetingfilm.film.controller.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.utils.vo.BaseResponsePageVO;
import lombok.Data;

import java.util.List;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 12:25
 */
@Data
public class DescribeFilmsRespPageVO extends BaseResponsePageVO<DescribeFilmsRespVO> {

    private List<DescribeFilmsRespVO> films;

    public DescribeFilmsRespPageVO(IPage<DescribeFilmsRespVO> page) {
        super(page);
        this.films = page.getRecords();
    }
}
