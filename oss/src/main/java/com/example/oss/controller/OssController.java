package com.example.oss.controller;

import com.example.oss.utils.R;
import com.example.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * com.example.oss.controller
 *
 * @author xzwnp
 * 2022/1/28
 * 19:07
 * Steps：
 */
@RestController
@RequestMapping("tour/upload")
@CrossOrigin
public class OssController {
    @Autowired
    OssService ossService;

    //上传景点封面的方法
    @PostMapping("attraction/cover")
    public R uploadCover(MultipartFile file) {
        String url = ossService.uploadFile(file,"attraction");
        return R.ok().data("url", url);
    }

    //上传景点详情图片的方法
    @PostMapping("attraction/pictures")
    public R uploadPictures(@RequestParam("pictures") MultipartFile[] files) {
        System.out.println("调用了景点上传");
        List<String> urls = ossService.uploadFileBatch(files,"attraction");
        return R.ok().data("urls", urls);
    }

    //上传用户头像的方法
    @PostMapping("user/avatar")
    public R uploadGuiderAvatar(MultipartFile file) {
        String url = ossService.uploadFile(file,"user");
        return R.ok().data("url", url);
    }

    //上传导游头像的方法
    @PostMapping("guider/avatar")
    public R uploadUserAvatar(MultipartFile file) {
        String url = ossService.uploadFile(file,"guider");
        return R.ok().data("url", url);
    }
}
