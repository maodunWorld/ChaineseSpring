package com.maodun.mongo.dao;

import com.maodun.mongo.pojo.TestDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tongjian
 * @version 1.0
 * @date 2020/5/12 16:52
 */


//指定TestDoc的Pojo，和String的主键
@Repository
public interface TestDocDao extends MongoRepository<TestDoc, String> {
}
