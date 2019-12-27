package com.zxb.meetingfilm.utils.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxb.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-26 17:00
 */
@Data
public class BaseResponsePageVO<T> {

    private Long totalSize;
    private Long totalPages;
    private Long pageSize;
    private Long nowPage;

    public BaseResponsePageVO(IPage<T> page) {
        this.totalSize = page.getTotal();
        this.totalPages = page.getPages();
        this.pageSize = page.getSize();
        this.nowPage = page.getCurrent();
    }

}
