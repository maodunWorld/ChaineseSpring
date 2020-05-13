package com.maodun.mongo.dao;

import com.maodun.mongo.pojo.TestDoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 10:59
 */
@DataMongoTest
class TestDocDaoTest {
    public static final String EXIST_DOC_CODE = "584f737b-2af0-4763-9bf1-a348c4d321e8";
    @Autowired
    private TestDocDao testDocDao;

    @Test
    public void findByCreatorIdIsTest() {
        Optional<List<TestDoc>> maodun = testDocDao.findByCreatorIdIs("maodun");
        maodun.get().forEach(System.out::println);
        Assertions.assertTrue(maodun.isPresent());
    }

    @Test
    public void findByDocCodeIsTest() {
        Optional<TestDoc> byDocCodeIs = testDocDao.findByDocCodeIs(EXIST_DOC_CODE);
        System.out.println(byDocCodeIs.get());
        Assertions.assertTrue(byDocCodeIs.isPresent());
    }

    @Test
    public void findByCreatorIdIsOrDocTextIsTest() {
        Optional<List<TestDoc>> maodun = testDocDao.findByCreatorIdIsOrDocTextIs("maodun", "12024b85-ce76-4651-ae9d-e8c557f7bbc2");
        Assertions.assertTrue(maodun.isPresent());
    }
}