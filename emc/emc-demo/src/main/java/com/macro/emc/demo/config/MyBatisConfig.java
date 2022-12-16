package com.macro.emc.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by jane on 2022/4/8.
 */
@Configuration
@MapperScan("com.macro.emc.mapper")
public class MyBatisConfig {
}
