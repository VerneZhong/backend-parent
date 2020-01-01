package com.zxb.meetingfilm.api.film.vo;

import lombok.Data;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 12:30
 */
@Data
public class DescribeFilmRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;
}
