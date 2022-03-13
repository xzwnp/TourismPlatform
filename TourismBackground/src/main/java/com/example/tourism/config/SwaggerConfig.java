package com.example.tourism.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * com.example.servicebase
 *
 * @author xzwnp
 * 2022/1/26
 * 21:09
 * Steps：
 */

@Configuration//配置类
@EnableSwagger2 //swagger注解
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))//配置希望被扫描的包
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .groupName("默认分组");

    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("旅游平台API文档")
                .description("本文档描述了旅游平台接口定义")
                .version("1.0")
                .contact(new Contact("欢迎访问个人网站", "rnm.yidongzhenka.top", "1123@qq.com"))
                .build();
    }
}

