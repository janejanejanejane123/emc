package com.macro.emc.portal;

import cn.hutool.core.convert.Convert;
import com.macro.emc.common.constant.AuthConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class MysqlRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /*
     * redis和mysql测试
     * */
    @Test
    public void redis() {
        //管理端路径需校验权限
        Map<Object, Object> resourceRolesMap = redisTemplate.opsForHash().entries(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        Iterator<Object> iterator = resourceRolesMap.keySet().iterator();
        List<String> authorities = new ArrayList<>();
        while (iterator.hasNext()) {
            String pattern = (String) iterator.next();
            authorities.addAll(Convert.toList(String.class, resourceRolesMap.get(pattern)));
        }
        authorities = authorities.stream().map(i -> i = AuthConstant.AUTHORITY_PREFIX + i).collect(Collectors.toList());
    }
}
