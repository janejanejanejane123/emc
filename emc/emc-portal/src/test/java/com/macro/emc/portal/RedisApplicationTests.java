package com.macro.emc.portal;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /*
     * redis
     * */
    @Test
    public void redis() {
        //管理端路径需校验权限

    }
}
