package com.macro.emc.portal.controller;

import com.macro.emc.common.api.CommonResult;
import com.macro.emc.model.UmsMember;
import com.macro.emc.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车管理Controller
 * Created by jane on 2022/12/15.
 */
@Controller
@Api(tags = "OmsCartItemController", description = "购物车管理")
@RequestMapping("/cart")
public class OmsCartItemController {

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation("获取某个会员的购物车列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMember>> list() {
        return CommonResult.success(memberService.list());
    }

}
