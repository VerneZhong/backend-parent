package com.zxb.meetingfilm.utils.vo;

import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 11:10
 */
@Data
public class BasePageVO extends BaseRequestVO {

    private Integer nowPage;
    private Integer pageSize;

    public BasePageVO() {
        this.nowPage = 1;
        this.pageSize = 10;
    }

    @Override
    public void checkParam() throws CommonServiceException {
        // 校验
        if (nowPage == null || pageSize == null) {
            throw new CommonServiceException(601, "分页参数不能为空");
        }
    }
}
