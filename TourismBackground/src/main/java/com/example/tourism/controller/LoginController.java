package com.example.tourism.controller;

import com.example.tourism.entity.Administrator;
import com.example.tourism.entity.vo.LoginInfo;
import com.example.tourism.service.LoginService;
import com.example.tourism.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * com.example.serviceedu.controller
 *
 * @author xzwnp
 * 2022/1/28
 * 11:47
 * Steps：
 */
@RestController
@RequestMapping("/admin")
@Api("管理员登录接口")
public class LoginController {
    @Autowired
    LoginService loginService;
    //login
    @PostMapping("login")
    @ApiOperation("")
    public R login(@RequestBody LoginInfo loginInfo) {
        Administrator administrator = new Administrator(loginInfo.getUsername(),loginInfo.getPassword());
        return loginService.login(administrator)?R.ok().data("token", "admin"):R.error().message("密码错误!");
    }

    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
