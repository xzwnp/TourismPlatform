package com.example.tourism.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.Guider;
import com.example.tourism.entity.vo.AttractionQuery;
import com.example.tourism.entity.vo.GuiderQuery;
import com.example.tourism.mapper.GuiderMapper;
import com.example.tourism.service.GuiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@Service
public class GuiderServiceImpl extends ServiceImpl<GuiderMapper, Guider> implements GuiderService {

    @Override
    public Page<Guider> conditionalPage(GuiderQuery query, Page<Guider> page) {
        if (query == null) {
            return this.page(page);
        }
        QueryWrapper<Guider> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (query.getTitle() != 0) {
            wrapper.eq("title", query.getTitle());
        }
        if (query.getMinWorkYears() != 0) {
            wrapper.ge("work_years", query.getMinWorkYears());
        }
        if (query.getMaxWorkYears() != 0) {
            wrapper.le("work_years", query.getMaxWorkYears());
        }
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public int saveAndReturnId(Guider guider) {
        return baseMapper.insert(guider);
    }
}
