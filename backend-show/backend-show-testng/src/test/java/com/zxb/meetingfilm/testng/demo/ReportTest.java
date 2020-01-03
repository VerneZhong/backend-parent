package com.zxb.meetingfilm.testng.demo;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-02 15:12
 */
@Slf4j
public class ReportTest {

    @Test
    public void report1() {
        log.error("ReportTest report-1");
    }

    @Test
    public void report2() {
//        int i = 1/0;
    }
}
