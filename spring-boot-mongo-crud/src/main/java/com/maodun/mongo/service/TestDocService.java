package com.maodun.mongo.service;

import com.maodun.mongo.dao.TestDocDao;
import com.maodun.mongo.pojo.TestDoc;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/12 16:52
 */
@Service
@Log
public class TestDocService {
    @Autowired
    private TestDocDao testDocDao;

    public void create(TestDoc testDoc) {
        testDocDao.insert(testDoc);
    }

    @Transactional(rollbackFor = Exception.class)
    public Long deleteOne(String id) {
        long l = testDocDao.deleteByIdIs(id);
        log.info(" -----------------delete id :{} ----result is :{}" + id + " result " + l);
        int i = 1 / 0;
        return l;
    }


}
