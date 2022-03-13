package com.example.tourism.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.Guider;
import com.example.tourism.entity.Guider;
import com.example.tourism.entity.vo.GuiderQuery;
import com.example.tourism.entity.vo.GuiderQuery;
import com.example.tourism.service.GuiderService;
import com.example.tourism.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
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
@RequestMapping("/tour/guider")
public class GuiderController {
    @Autowired
    GuiderService guiderService;

    @PostMapping("page/{page}/limit/{limit}")
    @ApiOperation("条件分页查询导游")
    public R getConditionalGuiderPage(@ApiParam("当前页码") @PathVariable("page") int current,
                                          @ApiParam("每页记录数") @PathVariable int limit,
                                          @ApiParam("条件,可以为空") @RequestBody(required = false) GuiderQuery query) {
        Page<Guider> page = new Page<>(current, limit);
        guiderService.conditionalPage(query, page);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    @PutMapping
    @ApiOperation("根据id进行更新导游")
    public R updateGuiderById(@RequestBody Guider guider) {
        try {
            guiderService.updateById(guider);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok();
    }

    @PostMapping
    @ApiOperation("新增导游,新增成功后,返回新增导游的id")
    public R saveGuider(@RequestBody Guider guider) {
        int id;
        try {
            id = guiderService.saveAndReturnId(guider);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok().data("id", id);
    }

    @GetMapping("{id}")
    public R getGuiderById(@PathVariable int id) {
        Guider guider = guiderService.getById(id);
        return !ObjectUtils.isEmpty(guider) ? R.ok().data("item", guider) : R.error().message("没有获取到");
    }

    @DeleteMapping("{id}")
    @Transactional
    public R deleteGuiderById(@PathVariable int id) {
        return guiderService.removeById(id) ? R.ok() : R.error().message("删除失败");
    }
}
