package com.macro.emc.demo.controller;

import com.macro.emc.common.api.CommonResult;
import com.macro.emc.demo.service.FeignPortalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用portal接口示例
 * Created by jane on 2022/12/15.
 */
@Api(tags = "FeignPortalController", description = "Feign调用portal接口示例")
@RestController
@RequestMapping("/feign/portal")
public class FeignPortalController {

    @Autowired
    private FeignPortalService portalService;

    @PostMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        return portalService.login(username,password);
    }

    @GetMapping("/cartList")
    public CommonResult cartList() {
        return portalService.list();
    }

    @PostMapping("/setRedisCacheUmsMember")
    public CommonResult setRedisCacheUmsMember() {
        return portalService.setRedisCacheUmsMember();
    }

}
