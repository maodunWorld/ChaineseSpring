package com.maodun.mongo.service;

import com.maodun.mongo.dao.TestDocDao;
import com.maodun.mongo.pojo.TestDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tongjian
 * @version 1.0
 * @date 2020/5/12 16:52
 */
@Service
public class TestDocService {
    @Autowired
    private TestDocDao testDocDao;


    public void create(TestDoc testDoc) {
        testDocDao.insert(testDoc);
    }
}
