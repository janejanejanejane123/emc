package com.macro.emc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by jane on 2022/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.macro.emc.mapper","com.macro.emc.dao"})
public class MyBatisConfig {
}
