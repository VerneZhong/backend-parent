package com.zxb.meetingfilm.testng.demo;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-02 14:54
 */
@Slf4j
public class TestNgDemo {

    @Test
    public void test() {
        log.error("this is test!");
    }

    @Test
    public void test2() {
        log.error("this is test 2!");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("this is before method!");
    }

    @AfterMethod
    public void afterMethod() {
        log.info("this is after method!");
    }

    @BeforeClass
    public void beforeClass() {
        log.info("this is before class!");
    }

    @AfterClass
    public void afterClass() {
        log.info("this is after class!");
    }

    @BeforeSuite
    public void beforeSuite() {
        log.info("this is before suite!");
    }

    @BeforeSuite
    public void afterSuite() {
        log.info("this is after suite!");
    }
}
