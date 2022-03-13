package com.example.tourism.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.Guider;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tourism.entity.vo.AttractionQuery;
import com.example.tourism.entity.vo.GuiderQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
public interface GuiderService extends IService<Guider> {

    Page<Guider> conditionalPage(GuiderQuery query, Page<Guider> page);

    int saveAndReturnId(Guider guider);
}
