package com.zxb.meetingfilm.hall.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxb.meetingfilm.hall.controller.vo.HallsReqVO;
import com.zxb.meetingfilm.hall.controller.vo.HallsRespVO;
import com.zxb.meetingfilm.hall.dao.entity.MoocFieldT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author Mr.zxb
 * @since 2019-12-28
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

    IPage<HallsRespVO> describeHalls(Page<HallsReqVO> page, @Param("ew") QueryWrapper queryWrapper);
}
