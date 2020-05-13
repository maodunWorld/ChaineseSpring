package com.maodun.mongo.dao;

import com.maodun.mongo.pojo.TestDoc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 10:59
 */
@DataMongoTest
class TestDocDaoTest {
    public static final String EXIST_DOC_CODE = "9a4a6cad-db29-41f9-a139-c4cc6f054168";
    public static final String EXIST_ID = "5ebb5a425191152a939d914e";
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

    @Test
    public void findByCreatorIdLikeTest() {
        Optional<List<TestDoc>> m = testDocDao.findByCreatorIdLike("m");
        Optional<List<TestDoc>> d = testDocDao.findByCreatorIdLike("d");
        List<TestDoc> testDocs = d.get();
        // 判断两者是否完全相同
        boolean b = m.get().stream().allMatch(e -> testDocs.contains(e));
        Assertions.assertTrue(b);
    }

    @Test
    public void findByDocCodeIsSortTest() {
        Optional<List<TestDoc>> desc = testDocDao.findByCreatorIdIs("maodun", Sort.by(Sort.Direction.DESC, "create_time"));
        Optional<List<TestDoc>> asc = testDocDao.findByCreatorIdIs("maodun", Sort.by(Sort.Direction.ASC, "create_time"));

        // 可以看到，顺序相反
        desc.get().forEach(System.out::println);
        System.out.println("--- ------ -----");
        asc.get().forEach(System.out::println);

    }

    @Test
    public void findByCreatorIdIsPageTest() {

        Page<TestDoc> page = testDocDao.findByCreatorIdIs("maodun", PageRequest.of(0, 5));
        //分页并排序
        Page<TestDoc> pageAndSort = testDocDao.findByCreatorIdIs("maodun", PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "create_time")));
        page.getContent().forEach(System.out::println);

        Assertions.assertEquals(5, page.getContent().size());
    }

    @Test
    public void updateTest() {
        TestDoc testDoc = new TestDoc();
        Optional<TestDoc> byId = testDocDao.findById("5eba874e86b84e3199b227da");
        if (byId.isPresent()) {
            TestDoc testDoc1 = byId.get();
            BeanUtils.copyProperties(testDoc1, testDoc);
            testDoc.setDocCode("update a docCode3");
        }
        TestDoc save = testDocDao.save(testDoc);
        System.out.println(save);
        Assertions.assertNotNull(save);
    }

    @Test
    public void deleteByIdIsTest() {
        long b = testDocDao.deleteByIdIs(EXIST_ID);
        // b=1 代表删除成功， b=0代表删除失败
        System.out.println(b);
        Optional<TestDoc> byId = testDocDao.findById(EXIST_ID);
        Assertions.assertFalse(byId.isPresent());
    }

    @Test
    public void deleteByDocCodeIs() {
        long l = testDocDao.deleteByDocCodeIs(EXIST_DOC_CODE);
        Assertions.assertEquals(1l, l);
    }

    ;
}