package com.maodun.mongo.controller;

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
import java.util.UUID;

/**
 * @author tongjian
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
//    @Autowired
//    private TransactionTemplate transactionTemplate;

    @GetMapping("/add_randomone")
    public ResponseEntity addRandomOne() {
        TestDoc testDoc = new TestDoc();
        Date time = new Date();
        testDoc.setCreateTime(time);
        testDoc.setCreatorId("maodun");
        testDoc.setDocCode(UUID.randomUUID().toString());
        testDoc.setDocText(UUID.randomUUID().toString());
        testDocService.create(testDoc);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/get_page/{pageIndex}")
    public ResponseEntity getPage(@PathVariable Integer pageIndex) {
        log.info(" -----  " + pageIndex + " -----");
        Sort create_time = Sort.by(Sort.Direction.ASC, "create_time");
        Page<TestDoc> all = testDocDao.findAll(PageRequest.of(pageIndex, 5, create_time));
        log.info("get data" + all.getContent().toString());
        return ResponseEntity.ok().body(all.getContent());
    }

    @PutMapping("/add_one")
    public ResponseEntity addOne(@RequestBody TestDoc testDoc) {
        TestDoc insert = testDocDao.insert(testDoc);
        return ResponseEntity.ok(insert);
    }
}
