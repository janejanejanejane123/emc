package com.macro.emc.portal.config;


import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.Invoice.mapper.MyDb2"}, sqlSessionFactoryRef = "SqlSessionFactoryMyDb2")
public class DbMyDb2Config {
//    @Autowired
//    private MybatisInterceptor mybatisInterceptor;

    @Resource
    @Qualifier("dsMyDb2")
    private DataSource dsMyDb2;

    /**
     * 创建sqlsessionfactory
     */
    @Bean(name = {"SqlSessionFactoryMyDb2"})
    public SqlSessionFactory sqlSessionFactoryMyDb2() throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dsMyDb2);
        org.springframework.core.io.Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/MyDb2/*.xml");
        sessionFactoryBean.setMapperLocations(resources);
        //sessionFactoryBean.setPlugins(new Interceptor[]{mybatisInterceptor});
        return sessionFactoryBean.getObject();
    }

    @Bean(name = {"dbMyDb2TransactionManager"})
    public DataSourceTransactionManager dbMyDb2TransactionManager(@Qualifier("dsMyDb2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate dbMyDb2SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryMyDb2());
    }
}

