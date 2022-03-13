package com.example.tourism.controller;


import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.AttractionDescription;
import com.example.tourism.service.AttractionDescriptionService;
import com.example.tourism.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/tour/attraction-description")
public class AttractionDescriptionController {
    @Autowired
    AttractionDescriptionService adService;

    @PutMapping
    @ApiOperation("根据id更新景点详情")
    public R updateAttractionDescriptionById(@RequestBody AttractionDescription attractionDescription) {
        try {
            adService.updateById(attractionDescription);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok();
    }

    @PostMapping
    @ApiOperation("新增景点详情")
    public R saveAttractionDescription(@RequestBody AttractionDescription attractionDescription) {
        //todo
        //需要先把传入的参数进行处理,即把pictures数组分解,分别存入
        try {
            adService.save(attractionDescription);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok();
    }

    @GetMapping("{id}")
    public R getAttractionById(@PathVariable int id) {
        AttractionDescription ad = adService.getById(id);
        return R.ok().data("item", ad);
    }

    @PostMapping("save-or-update")
    @ApiOperation("新增或保存景点详情")
    public R saveOrUpdate(@RequestBody AttractionDescription attractionDescription) {
        //去掉头尾的引号
        String urls = attractionDescription.getPictures();

        if (StringUtils.hasLength(urls)) {
            urls = urls.replaceAll("\\\\", "");
            attractionDescription.setPictures(urls);
            System.out.println(urls);
        }
        try {
            adService.saveOrUpdate(attractionDescription);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }

        return R.ok();
    }

}
