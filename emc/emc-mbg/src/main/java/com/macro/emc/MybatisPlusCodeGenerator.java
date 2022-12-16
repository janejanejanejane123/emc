package com.macro.emc;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

//执行 main 方法，控制台输入模块表名，回车自动生成对应项目目录中
public class MybatisPlusCodeGenerator {

    public static void main(String[] args) {
        //====================配置变量区域=====================//
        String author="";//生成文件的作者，可以不填
        String rootPackage="org.example.xxxx";//生成的entity、controller、service等包所在的公共上一级包路径全限定名
        String moduleName="province-sess-platfrom-xqxy";
        //数据库配置
        String url="jdbc:mysql://192.168.xxx.xxx:3306/xxx?useSSL=false&characterEncoding=utf8";
        String driverClassName="com.mysql.jdbc.Driver";//或者com.mysql.cj.jdbc.Driver
        String username="root";
        String password="xxxxxx";
        String tableNames="annualplan";//表名，多个使用,分隔
        //====================配置变量区域=====================//

        // 代码生成器
        FastAutoGenerator.create("url", "username", "password")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_simple") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
