package com.example.tourism.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tourism.entity.Administrator;

/**
 * com.example.tourism.service.impl
 *
 * @author xzwnp
 * 2022/3/1
 * 22:01
 * Steps：
 */
public interface LoginService extends IService<Administrator> {
    public boolean login(Administrator admin);
}
