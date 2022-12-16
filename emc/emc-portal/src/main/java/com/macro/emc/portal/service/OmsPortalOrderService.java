package com.macro.emc.portal.service;

import com.macro.emc.common.api.CommonPage;
import com.macro.emc.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理Service
 * Created by jane on 2022/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
