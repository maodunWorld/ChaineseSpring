package com.maodun.dao;

import com.maodun.User;
import com.maodun.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tongjian
 * @date 2020/6/8 14:34
 */
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    void test1() {
        List<User> all = userDao.findAll();
        assertThat(all.isEmpty()).isFalse();
    }

    @Test
    void pageRequest() {
        Slice<User> all = userDao.findAll(CassandraPageRequest.of(0, 100));
        assertThat(all.isEmpty()).isFalse();
    }

}