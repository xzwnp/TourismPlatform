package com.example.tourism.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tourism.entity.Administrator;
import com.example.tourism.mapper.AdminMapper;
import com.example.tourism.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Wrapper;

/**
 * com.example.tourism.service.impl
 *
 * @author xzwnp
 * 2022/3/1
 * 22:02
 * Steps：
 */
@Service
public class LoginServiceImpl extends ServiceImpl<AdminMapper, Administrator> implements LoginService {
    @Override
    public boolean login(Administrator admin){
        QueryWrapper<Administrator> wrapper = new QueryWrapper<>();
        wrapper.eq("account",admin.getAccount());
        wrapper.eq("password",admin.getPassword());
        return !ObjectUtils.isEmpty(baseMapper.selectOne(wrapper));
    }
}
