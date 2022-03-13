package com.example.tourism.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.UserInfo;
import com.example.tourism.entity.vo.UserQuery;
import com.example.tourism.mapper.UserInfoMapper;
import com.example.tourism.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-02-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public Page<UserInfo> conditionalPage(UserQuery query, Page<UserInfo> page) {
        if (query == null) {
            return this.page(page);
        }
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(query.getNickname())) {
            wrapper.like("nickname", query.getNickname());
        }

        if (StringUtils.hasLength(query.getUsername())) {
            wrapper.like("username", query.getUsername());
        }
        if (StringUtils.hasLength(query.getCreateTimeBegin())) {
            wrapper.ge("gmt_create", query.getCreateTimeBegin());
        }
        if (StringUtils.hasLength(query.getCreateTimeEnd())) {
            wrapper.le("gmt_create", query.getCreateTimeEnd());
        }
        return baseMapper.selectPage(page,wrapper);
    }

}
