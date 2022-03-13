package com.example.tourism.controller;


import com.example.tourism.entity.City;
import com.example.tourism.service.CityService;
import com.example.tourism.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/tour/city")
public class CityController {
    @Autowired
    CityService cityService;
    @GetMapping
    public R getCityList(){
        List<City> cityList = cityService.list();
        return R.ok().data("list",cityList);
    }



}
