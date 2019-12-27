package com.zxb.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 12:23
 */
@Data
public class DescribeFilmsRespVO {

    private Integer filmId;
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;

}
