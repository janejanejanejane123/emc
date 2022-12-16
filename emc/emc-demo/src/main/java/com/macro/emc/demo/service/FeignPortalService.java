package com.macro.emc.demo.service;

import com.macro.emc.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jane on 2022/12/15.
 */
@FeignClient(name = "portal",url = "http://localhost:8085")
public interface FeignPortalService {

    @PostMapping("/sso/login")
    CommonResult login(@RequestParam String username, @RequestParam String password);

    @GetMapping("/cart/list")
    CommonResult list();

    @PostMapping("/test/setRedisCacheUmsMember")
    CommonResult setRedisCacheUmsMember();
}
