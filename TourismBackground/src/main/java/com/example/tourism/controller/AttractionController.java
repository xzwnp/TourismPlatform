package com.example.tourism.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Attraction;
import com.example.tourism.entity.vo.AttractionQuery;
import com.example.tourism.service.AttractionService;
import com.example.tourism.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/tour/attraction")
public class AttractionController {
    @Autowired
    AttractionService attractionService;


    @PostMapping("page/{page}/limit/{limit}")
    @ApiOperation("条件分页查询景点")
    public R getConditionalAttractionPage(@ApiParam("当前页码") @PathVariable("page") int current,
                                          @ApiParam("每页记录数") @PathVariable int limit,
                                          @ApiParam("条件,可以为空") @RequestBody(required = false) AttractionQuery query) {
        Page<Attraction> page = new Page<>(current, limit);
        attractionService.conditionalPage(query, page);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    @PutMapping
    @ApiOperation("根据id进行更新景点")
    public R updateAttractionById(@RequestBody Attraction attraction) {
        try {
            attractionService.updateById(attraction);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok();
    }

    @PostMapping
    @ApiOperation("新增景点,新增成功后,返回新增景点的id")
    public R saveAttraction(@RequestBody Attraction attraction) {
        int id;
        try {
            id = attractionService.saveAndReturnId(attraction);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok().data("id", id);
    }

    @GetMapping("{id}")
    public R getAttractionById(@PathVariable int id) {
        Attraction attraction = attractionService.getById(id);
        return !ObjectUtils.isEmpty(attraction) ? R.ok().data("item", attraction) : R.error().message("没有获取到");
    }

    @DeleteMapping("{id}")
    @Transactional
    public R deleteAttractionById(@PathVariable int id) {
        return attractionService.removeBoth(id) ? R.ok() : R.error().message("删除失败");
    }
}
