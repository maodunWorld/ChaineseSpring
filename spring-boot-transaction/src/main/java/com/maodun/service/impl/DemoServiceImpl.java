package com.maodun.service.impl;

import com.maodun.dao.DemoDao;
import com.maodun.pojo.Demo;
import com.maodun.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

//    @Autowired
//    private TransactionalOperator transactionalOperator;

    /**
     * 当没有Transactional注解时，数据库将会插入成功
     * 当有Transactional注解时，数据会插入失败
     *
     * @param demo
     * @return
     */
    @Override
    @Transactional
    public boolean saveDemo(Demo demo) {
        demoDao.save(demo);
        throw new NullPointerException();
    }

    /**
     * 编程式事务
     *
     * @param demo
     * @return
     */
    @Override
    public boolean saveDemo1(Demo demo) {
        Boolean execute = transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                demoDao.save(demo);
                throw new NullPointerException();
                //return true;
            }
        });
        return execute;
    }


    @Override
    public boolean saveDemo2(Demo demo) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName(demo.getId());
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        try {
            demoDao.save(demo);
            throw new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);
            return false;
        }
//        platformTransactionManager.commit(status);
//        return true;
    }


}
