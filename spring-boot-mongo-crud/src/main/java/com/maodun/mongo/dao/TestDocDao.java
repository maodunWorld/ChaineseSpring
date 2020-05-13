package com.maodun.mongo.dao;

import com.maodun.mongo.pojo.TestDoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/12 16:52
 */


//指定TestDoc的Pojo，和String的主键
@Repository
public interface TestDocDao extends MongoRepository<TestDoc, String> {
    Optional<List<TestDoc>> findByCreatorIdIs(String creatorId);

    Optional<TestDoc> findByDocCodeIs(String docCode);

    Optional<List<TestDoc>> findByCreatorIdIsOrDocTextIs(String creatorId, String docText);

    Optional<List<TestDoc>> findByCreatorIdLike(String creatorId);

    Optional<List<TestDoc>> findByCreatorIdIs(String creatorId, Sort sort);

    Page<TestDoc> findByCreatorIdIs(String creatorId, Pageable pageable);

    long deleteByIdIs(String id);

    long deleteByDocCodeIs(String docCode);

}
