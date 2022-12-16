package com.macro.emc.demo.controller;

/**
 * Created by jane on 2022/12/15.
 */

import com.macro.emc.common.api.CommonResult;
import com.macro.emc.demo.dto.UmsAdminLoginParam;
import com.macro.emc.demo.service.FeignAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用admin接口示例
 */
@Api(tags = "FeignAdminController", description = "Feign调用admin接口示例")
@RestController
@RequestMapping("/feign/admin")
public class FeignAdminController {
    @Autowired
    private FeignAdminService adminService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam) {
        return adminService.login(loginParam);
    }

    @GetMapping("/getBrandList")
    public CommonResult getBrandList(){
        return adminService.getList();
    }
}
