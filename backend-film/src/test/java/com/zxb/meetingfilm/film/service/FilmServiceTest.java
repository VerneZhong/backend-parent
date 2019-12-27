package com.zxb.meetingfilm.film.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-27 15:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FilmServiceTest {

    @Autowired
    private FilmServiceAPI filmServiceAPI;

    @Test
    public void testSelect() {
        System.out.println(filmServiceAPI.describeActors(1 ,10).getRecords());
    }
}
