package com.example.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tourism.entity.AttractionDescription;
import com.example.tourism.mapper.AttractionDescriptionMapper;
import com.example.tourism.service.AttractionDescriptionService;
import org.springframework.stereotype.Service;

/**
 * com.example.tourism.service.impl
 *
 * @author xzwnp
 * 2022/3/4
 * 13:56
 * Steps：
 */
@Service
public class AttractionDescriptionServiceImpl extends ServiceImpl<AttractionDescriptionMapper, AttractionDescription> implements AttractionDescriptionService {
}
