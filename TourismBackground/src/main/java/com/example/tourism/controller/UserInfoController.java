package com.example.tourism.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tourism.entity.UserInfo;
import com.example.tourism.entity.vo.UserQuery;
import com.example.tourism.service.UserInfoService;
import com.example.tourism.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-02-26
 */
@RestController
@RequestMapping("/tour/user")
@Api("用户信息管理接口")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping()
    @ApiOperation("新增用户")
    public R saveUser(@RequestBody UserInfo userInfo) {

        boolean save = userInfoService.save(userInfo);
        return save ? R.ok() : R.error().message("保存失败!");
    }

    @GetMapping("findAll")
    @ApiOperation("查询所有用户")
    public R findAllUser() {
        List<UserInfo> list = userInfoService.list();
        return R.ok().data("list", list);
    }

    @PostMapping("page/{page}/limit/{limit}")
    @ApiOperation("条件分页查询导游")
    public R getConditionalUserInfoPage(@ApiParam("当前页码") @PathVariable("page") int current,
                                        @ApiParam("每页记录数") @PathVariable int limit,
                                        @ApiParam("条件,可以为空") @RequestBody(required = false) UserQuery query) {
        Page<UserInfo> page = new Page<>(current, limit);
        userInfoService.conditionalPage(query, page);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    @PutMapping
    @ApiOperation("根据id进行更新导游")
    public R updateUserInfoById(@RequestBody UserInfo user) {
        try {
            userInfoService.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().message("保存失败,请检查填写的信息!");
        }
        return R.ok();
    }

    @GetMapping("{id}")
    public R getUserInfoById(@PathVariable int id) {
        UserInfo user = userInfoService.getById(id);
        return !ObjectUtils.isEmpty(user) ? R.ok().data("item", user) : R.error().message("没有获取到");
    }

    @DeleteMapping("{id}")
    @Transactional
    public R deleteUserInfoById(@PathVariable int id) {
        return userInfoService.removeById(id) ? R.ok() : R.error().message("删除失败");
    }

}
