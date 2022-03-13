package com.example.tourism.service.impl;

import com.example.tourism.entity.City;
import com.example.tourism.mapper.LocationMapper;
import com.example.tourism.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@Service
public class CityServiceImpl extends ServiceImpl<LocationMapper, City> implements CityService {

}
