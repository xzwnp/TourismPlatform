package com.example.tourism.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.vo.AttractionQuery;
import com.example.tourism.mapper.AttractionDescriptionMapper;
import com.example.tourism.mapper.AttractionMapper;
import com.example.tourism.service.AttractionDescriptionService;
import com.example.tourism.service.AttractionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tourism.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@Service
public class AttractionServiceImpl extends ServiceImpl<AttractionMapper, Attraction> implements AttractionService {

    @Autowired
    AttractionDescriptionService descriptionService;

    @Override
    public Page<Attraction> conditionalPage(AttractionQuery query, Page<Attraction> page) {
        if (query == null) {
            return this.page(page);
        }
        QueryWrapper<Attraction> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (query.getLocationId() != 0) {
            wrapper.eq("location_id", query.getLocationId());
        }
        if (StringUtils.hasLength(query.getBegin())) {
            wrapper.ge("gmt_create", query.getBegin());
        }
        if (StringUtils.hasLength(query.getEnd())) {
            wrapper.le("gmt_create", query.getEnd());
        }
        return baseMapper.selectPage(page, wrapper);
    }


    @Override
    public int saveAndReturnId(Attraction attraction) {
        return baseMapper.insert(attraction);
    }

    @Override
    public boolean removeBoth(int id) {
        return descriptionService.removeById(id) && this.removeById(id);
    }


}
