package com.example.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.example.tourism.controller
 *
 * @author xzwnp
 * 2022/2/26
 * 14:02
 * Steps：
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping()
    public String say(){
        return "你好";
    }
}
