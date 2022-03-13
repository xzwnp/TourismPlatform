package com.example.tourism.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.Guider;
import com.example.tourism.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tourism.entity.vo.GuiderQuery;
import com.example.tourism.entity.vo.UserQuery;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-02-26
 */
public interface UserInfoService extends IService<UserInfo> {

    Page<UserInfo> conditionalPage(UserQuery query, Page<UserInfo> page);
}
