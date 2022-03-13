package com.example.tourism.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tourism.entity.vo.AttractionQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
public interface AttractionService extends IService<Attraction> {
    Page<Attraction> conditionalPage(AttractionQuery query, Page<Attraction> page);

    int saveAndReturnId(Attraction attraction);

    @Transactional
    boolean removeBoth(int id);
}
