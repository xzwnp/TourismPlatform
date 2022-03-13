package com.example.tourism.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * com.example.tourism.config
 *
 * @author xzwnp
 * 2022/2/26
 * 22:08
 * Steps：
 */
@Configuration
//MapperScan需要具体到某个包,或者使用通配符
@MapperScan("com.example.tourism.mapper")

public class GlobalConfig {

}
