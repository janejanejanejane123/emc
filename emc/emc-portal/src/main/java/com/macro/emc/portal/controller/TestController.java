package com.macro.emc.portal.controller;

import com.macro.emc.common.api.CommonResult;
import com.macro.emc.model.UmsMember;
import com.macro.emc.portal.service.UmsMemberCacheService;
import com.macro.emc.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 首页内容管理Controller
 * Created by jane on 2022/1/28.
 */
@Controller
@Api(tags = "TestController", description = "首页内容管理")
    @RequestMapping("/test")
public class TestController {

    @Autowired
    private UmsMemberCacheService umsMemberCacheService;

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("setRedisCacheUmsMember")
    @RequestMapping(value = "/setRedisCacheUmsMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setRedisCacheUmsMember() {
        UmsMember umsMember = new UmsMember();
        umsMemberCacheService.setMember(umsMember);
        return CommonResult.success(null);
    }

    @ApiOperation("getRedisCacheUmsMember")
    @RequestMapping(value = "/getRedisCacheUmsMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsMember> getRedisCacheUmsMember() {
        UmsMember umsMember = umsMemberCacheService.getMember(1l);
        return CommonResult.success(umsMember);
    }

    @ApiOperation("updateRedisCacheUmsMember")
    @RequestMapping(value = "/updateRedisCacheUmsMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRedisCacheUmsMember() {
        umsMemberService.updateIntegration(1l, 1);
        return CommonResult.success(null);
    }


    @ApiOperation("updateMysqlRedisCacheUmsMember")
    @RequestMapping(value = "/updateMysqlRedisCacheUmsMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateMysqlRedisCacheUmsMember() {
        umsMemberService.updateIntegration2(1l, 1);
        return CommonResult.success(null);
    }


    @ApiOperation("updateRedisCacheUmsMemberError")
    @RequestMapping(value = "/updateRedisCacheUmsMemberError", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRedisCacheUmsMemberError() {
        umsMemberService.updateIntegration(1l, 1);
        return CommonResult.success(null);
    }


    @ApiOperation("delRedisCacheUmsMember")
    @RequestMapping(value = "/delRedisCacheUmsMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delRedisCacheUmsMember() {
        UmsMember umsMember = new UmsMember();
        umsMemberCacheService.delMember(1l);
        return CommonResult.success(null);
    }
}
