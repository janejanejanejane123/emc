package com.macro.emc.portal;

//import com.macro.emc.portal.component.SpringBootProducer;


import com.macro.emc.mapper.UmsMemberMapper;
import com.macro.emc.model.UmsMember;
import com.macro.emc.portal.domain.MemberReadHistory;
import com.macro.emc.portal.service.impl.UmsMemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class MysqlApplicationTests {

    private static final Logger Log = LoggerFactory.getLogger(MongodbApplicationTests.class);
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private UmsMemberServiceImpl umsMemberService;


    @Test
    public void mybatisplus() {
        UmsMember umsMember = umsMemberService.getById(1);
        if (umsMember == null) {
            synchronized (UmsMember.class) {
                UmsMember umsMember1 = umsMemberService.getById(1);
                if (umsMember1 == null) {
                    umsMemberService.save(new UmsMember());
                }
            }
        }
    }

    /*
     * 测试场景：mysql并发插入insert情况下数据重复
     * 解决方案：1.唯一索引。
     * 2.代码里双重检验加锁。
     * 3.加防重表。防重表和添加商品的操作必须要在同一个事务中，在添加商品数据之前，先添加防重表。如果添加成功，则说明可以正常添加商品，如果添加失败，则说明有重复数据。防重表添加失败，后续的业务处理，要根据实际业务需求而定。如果业务上允许添加一批商品时，发现有重复的，直接抛异常，则可以提示用户：系统检测到重复的商品，请刷新页面重试。
     * 4.要求表中存在唯一索引或PRIMARY KEY,insert ignore
     * 5.要求表中存在唯一索引或PRIMARY KEY,insert on duplicate key update
     * */
    @Test
    public void repeatInsert() {
        //1.唯一索引。
        UmsMember umsMember = new UmsMember("用户名");
        try {
            boolean save2 = umsMemberService.save(umsMember);
        } catch (Exception e) {
            Log.error("重复插入数据", e.getMessage());
        }
        int insert = umsMemberMapper.save(umsMember);
        System.out.println(insert);
        try {
            int insert2 = umsMemberMapper.saveDuplicate(umsMember);
        } catch (Exception e) {
            Log.error("重复插入数据", e.getMessage());
        }

        umsMemberService.ums_member_copy1save(umsMember);
    }

    /*
     * 主从同步，读写分离测试
     * */
    @Test
    public void masterSlave() {
        UmsMember umsMember1 = umsMemberMapper.selectById(1);
        System.out.println(umsMember1);
        UmsMember umsMember = new UmsMember();
        umsMember.setBirthday(new Date());
        int insert = umsMemberMapper.insert(umsMember);
        System.out.println(insert);
        int i = umsMemberMapper.updateByPrimaryKey(umsMember);
        System.out.println(i);
        UmsMember umsMember2 = umsMemberMapper.selectById(1);
        System.out.println(umsMember2);
    }


    /*
     * 模拟主从同步失败，旧的数据又被修改。重复增加100的额度。
     * */
    public List<MemberReadHistory> productMemberReadHistory(int num) {
        List<MemberReadHistory> memberReadHistoryList = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(num);
        // 配置线程池个数
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        MemberReadHistory memberReadHistory = new MemberReadHistory();
                        memberReadHistory.setMemberId(1l);
                        memberReadHistory.setMemberNickname("memberNickname");
                        memberReadHistory.setMemberIcon("memberIcon");
                        memberReadHistory.setId(null);
                        memberReadHistory.setCreateTime(new Date());
                        memberReadHistoryList.add(memberReadHistory);
                        // 一直阻塞当前线程，直到计数器值为0，保证并发
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            latch.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberReadHistoryList;
    }

}
