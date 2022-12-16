package com.macro.emc.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.macro.emc.common.api.CommonPage;
import com.macro.emc.common.exception.Asserts;
import com.macro.emc.common.service.RedisService;
import com.macro.emc.model.*;
import com.macro.emc.portal.component.CancelOrderSender;
import com.macro.emc.portal.domain.*;
import com.macro.emc.portal.service.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 前台订单管理Service
 * Created by jane on 2022/8/30.
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public void cancelOrder(Long orderId) {
        //查询未付款的取消订单
        cancelOrderSender.sendMessage(1l, 0);
        return;
    }
}
