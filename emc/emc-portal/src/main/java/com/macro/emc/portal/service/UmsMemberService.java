package com.macro.emc.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.emc.common.api.CommonResult;
import com.macro.emc.common.domain.UserDto;
import com.macro.emc.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by jane on 2022/8/3.
 */
public interface UmsMemberService extends IService<UmsMember> {
     /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id, Integer integration);

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration2(Long id, Integer integration);
}
