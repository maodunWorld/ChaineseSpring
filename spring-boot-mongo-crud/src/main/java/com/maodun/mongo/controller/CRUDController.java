package com.maodun.mongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.maodun.mongo.dao.TestDocDao;
import com.maodun.mongo.pojo.TestDoc;
import com.maodun.mongo.service.TestDocService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/12 16:14
 */
@RestController
@Log
public class CRUDController {

    @Autowired
    private TestDocService testDocService;

    @Autowired
    private TestDocDao testDocDao;

    @Autowired
    private ObjectMapper objectMapper;

    // Create
    @PutMapping("/testdoc")
    public ResponseEntity create(@RequestBody TestDoc testDoc) {
        log.info("--PUTING--" + testDoc);
        TestDoc insert = testDocDao.save(testDoc);
        log.info("--AFTER PUTING--" + insert);
        return ResponseEntity.ok(insert);
    }


    @PutMapping("/randomone")
    public ResponseEntity createRandomOne() {
        TestDoc testDoc = new TestDoc();
        Date time = new Date();
        testDoc.setCreateTime(time);
        testDoc.setCreatorId("maodun");
        testDoc.setDocCode(UUID.randomUUID().toString());
        testDoc.setDocText(UUID.randomUUID().toString());
        TestDoc insert = testDocDao.insert(testDoc);
        log.info(insert.toString());
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/multi-create")
    public ResponseEntity createMulti(@RequestBody String multipleJson) throws JsonProcessingException {
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, TestDoc.class);
        List<TestDoc> testDocs = (List<TestDoc>) objectMapper.readValue(multipleJson, collectionType);
        List<TestDoc> result = testDocDao.insert(testDocs);
        if (result != null) {
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.badRequest().body("FAIL");
        }
    }

    // retrieve
    @GetMapping("/testdoc/p{pageIndex}")
    public ResponseEntity retrievePage(@PathVariable Integer pageIndex) {
        log.info(" -----  " + pageIndex + " -----");
        Sort create_time = Sort.by(Sort.Direction.ASC, "create_time");
        Page<TestDoc> all = testDocDao.findAll(PageRequest.of(pageIndex, 5, create_time));
        log.info("get data" + all.getContent().toString());
        return ResponseEntity.ok().body(all.getContent());
    }


    @DeleteMapping("/testdoc")
    public ResponseEntity delete(@RequestBody TestDoc testDoc) {
        return null;
    }

    @PatchMapping("/testdoc")
    public ResponseEntity update(@RequestBody TestDoc testDoc) {
        return null;
    }

    @DeleteMapping("/transaction")
    public ResponseEntity transactionTest(@RequestBody TestDoc testDoc) {
        long result = testDocService.deleteOne(testDoc.getId());
        return ResponseEntity.ok(result);
    }
}
