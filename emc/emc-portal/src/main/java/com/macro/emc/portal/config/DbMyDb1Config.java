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
@MapperScan(basePackages = {"com.mapper.MyDb1"}, sqlSessionFactoryRef = "SqlSessionFactoryMyDb1")
public class DbMyDb1Config {
//    @Autowired
//    private MybatisInterceptor mybatisInterceptor;

    @Resource
    @Qualifier("dsMyDb1")
    private DataSource dsMyDb1;

    /**
     * 创建sqlsessionfactory
     */
    @Bean(name = {"SqlSessionFactoryMyDb1"})
    @Primary
    public SqlSessionFactory sqlSessionFactoryMyDb1() throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dsMyDb1);
        org.springframework.core.io.Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/MyDb1/*.xml");
        sessionFactoryBean.setMapperLocations(resources);
        //sessionFactoryBean.setPlugins(new Interceptor[]{mybatisInterceptor});
        return sessionFactoryBean.getObject();
    }

    @Bean(name = {"dbMyDb1TransactionManager"})
    @Primary
    public DataSourceTransactionManager dbMyDb1TransactionManager(@Qualifier("dsMyDb1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate dbMyDb1SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryMyDb1());
    }
}


