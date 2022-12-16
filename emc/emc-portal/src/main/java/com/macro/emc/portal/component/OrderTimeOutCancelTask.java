package com.macro.emc.portal.component;

import com.macro.emc.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jane on 2022/8/24.
 * 订单超时取消并解锁库存的定时器
 */
@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER =LoggerFactory.getLogger(OrderTimeOutCancelTask.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/1 * ? * ?")
    private void cancelTimeOutOrder(){
        portalOrderService.cancelOrder(1l);
        LOGGER.info("取消订单，并根据sku编号释放锁定库存，取消订单数量：{}",1l);
    }
}
