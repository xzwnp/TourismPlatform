package com.example.tourism;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.example.tourism
 *
 * @author xzwnp
 * 2022/2/26
 * 21:29
 * mp代码生成器
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //需要被扫描的表
        String[] tableNames = {"t_guider", "t_attraction","t_attraction_description","t_location"};


        String projectPath = System.getProperty("user.dir");
        String url = "jdbc:mysql://localhost:3306/tourism?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "x.z.w.91";


        List<String> tables = new ArrayList<>(Arrays.asList(tableNames));

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("xiaozhiwei") // 设置作者
                            .enableSwagger()// 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()//是否禁用生成后打开资源管理器
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名(groupId)
                            .moduleName("tourism") // 设置父包模块名
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper"));

                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("t_") // 让生成的类名去掉前缀
                            //下面是service类相关配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            //下面是实体类相关配置
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("is_deleted")
                            .enableTableFieldAnnotation()
                            //controller类相关配置
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .enableHyphenStyle()//url中驼峰转连字符
                    ;


                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
