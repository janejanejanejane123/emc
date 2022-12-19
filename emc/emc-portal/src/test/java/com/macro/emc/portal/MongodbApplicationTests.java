package com.macro.emc.portal;


import com.macro.emc.portal.domain.MemberReadHistory;
import com.macro.emc.portal.repository.MemberReadHistoryRepository;
import com.mongodb.DuplicateKeyException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongodbApplicationTests {

    private static final Logger Log = LoggerFactory.getLogger(MongodbApplicationTests.class);

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /*
     * 问题：Java中MongoDB重复数据插入性能测试
     * 测试场景：多进程同时更新数据库时产生的upsert问题：两条相同的数据并发进行upsert操作，当同时查询到mongo库里数据不存在时，会转为insert操作，这时插入一条数据成功后，另一条数据再次插入时就会出现主键重复的问题。
     * 解决方案：upsert+唯一索引
     * 缺点：upsert操作会先在集合中进行数据查找，如果数据已经存在，则更新，否则插入。数据的查找那就势必会使用索引，mongo索引用的是B树，时间复杂度为Olog(n)，而没有索引的情况下则时间复杂度是O(n)。
     * mongodb索引的存储机制和mysql不同，mysql的索引是存储在硬盘中，需要时会调用部分到内存中。而mongodb的索引则是直接存储在内存和临时文件中，并且和内存大小限制有很直接的关系，如果超过内存限制，则从硬盘加载索引。
     * 所以mongodb索引的使用，在大数据集合面前，会面临内存耗尽的风险。随着数据日益增多，upsert性能是线性下滑的，导致upsert速度越来越慢。
     * 适用场景：写多读少的场景，不适合对集合加入索引
     */
    @Test
    public void mongodb2() throws IllegalAccessException {
        //使用Upsert进行插入，如果存在就更新，不存在则插入
        //根据报告时间和code进行筛选去重
        MemberReadHistory memberReadHistory = new MemberReadHistory();
        Query query = new Query();
        query.addCriteria(Criteria.where("createTime").is(memberReadHistory.getCreateTime()));
        //建立更新update类
        Update update = new Update();
        //下面步骤可以替换成想要的对象。这里我用的反射让每个属性值赋值在update集合中。
        Field[] declaredFields = MemberReadHistory.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            update.set(declaredField.getName(), declaredField.get(memberReadHistory));
            declaredField.setAccessible(false);
        }
        //插入对应集合
        UpdateResult upsert = mongoTemplate.upsert(query, update, MemberReadHistory.class);
        System.out.println(upsert);
    }

    public void copyMemberReadHistoryToMongodbThreadPool() {
        // 配置线程池个数
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //根据报告时间和code进行筛选去重
                        MemberReadHistory memberReadHistory = new MemberReadHistory();
                        Query query = new Query();
                        query.addCriteria(Criteria.where("createTime").is(memberReadHistory.getCreateTime()));
                        //建立更新update类
                        Update update = new Update();
                        //下面步骤可以替换成想要的对象。这里我用的反射让每个属性值赋值在update集合中。
                        Field[] declaredFields = MemberReadHistory.class.getDeclaredFields();
                        for (Field declaredField : declaredFields) {
                            declaredField.setAccessible(true);
                            update.set(declaredField.getName(), declaredField.get(memberReadHistory));
                            declaredField.setAccessible(false);
                        }
                        //插入对应集合
                        mongoTemplate.upsert(query, update, MemberReadHistory.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyMemberReadHistoryToMongodbThreadPool(List<MemberReadHistory> cartList) {
        final CountDownLatch latch = new CountDownLatch(cartList.size());
        // 配置线程池个数
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            for (MemberReadHistory cart : cartList) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            memberReadHistoryRepository.save(cart);
                            // 一直阻塞当前线程，直到计数器值为0，保证并发
                            latch.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                latch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
