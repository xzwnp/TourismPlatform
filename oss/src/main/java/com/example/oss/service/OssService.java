package com.example.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * com.example.oss.service
 *
 * @author xzwnp
 * 2022/1/28
 * 19:07
 * Steps：
 */
public interface OssService {
    List<String> uploadFileBatch(MultipartFile[] files,String dirName);

    /**
     * @param dirName 指定文件上传到哪个文件夹下面
     */
    String uploadFile(MultipartFile file, String dirName);
}
