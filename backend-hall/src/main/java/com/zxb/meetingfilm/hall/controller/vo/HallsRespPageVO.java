package com.zxb.meetingfilm.hall.controller.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.utils.vo.BaseResponsePageVO;
import lombok.Data;

import java.util.List;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-28 10:33
 */
@Data
public class HallsRespPageVO extends BaseResponsePageVO<HallsRespVO> {

    private List<HallsRespVO> actors;

    public HallsRespPageVO(IPage<HallsRespVO> page) {
        super(page);
        this.actors = page.getRecords();
    }
}
