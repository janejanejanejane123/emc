package com.macro.emc.portal.config;//package com.macro.emc.portal.config;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Properties;
//
//@Component
//@Intercepts({@Signature(type = Executor.class, method = "query",
//        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
//public class MybatisInterceptor implements Interceptor {
//
//    @Value("${mybatis.max_row}")
//    private Integer max_row;
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        invocation.getArgs()[2] = new RowBounds(0, (null == max_row || 0 == max_row) ? 10000 : max_row);
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object o) {
//        return Plugin.wrap(o, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
//
