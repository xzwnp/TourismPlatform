package com.example.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.oss.service.OssService;
import com.example.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * com.example.oss.service.impl
 *
 * @author xzwnp
 * 2022/1/28
 * 19:07
 * Steps：
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public List<String> uploadFileBatch(MultipartFile[] files, String dirName) {
        //使用工具类获取值
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        OSS ossClient = null;
        List<String> urlList = new ArrayList<>();
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            for (MultipartFile file : files) {

                //设置文件名
                String filename = file.getOriginalFilename();
                String filePath = generateFileName(filename, dirName);

                String url = "";
                // 获取上传文件输入流
                InputStream inputStream = file.getInputStream();
                //调用oss方法实现上传
                ossClient.putObject(bucketName, filePath, inputStream);
                url = "https://" + bucketName + "." + endpoint + "/" + filePath;
                urlList.add(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient。
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return urlList;
    }

    @Override
    public String uploadFile(MultipartFile file, String dirName) {
        //使用工具类获取值
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        //设置文件名
        String filename = file.getOriginalFilename();
        String filePath = this.generateFileName(filename, dirName);
        OSS ossClient = null;
        String url = "";
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 获取上传文件输入流
            InputStream inputStream = file.getInputStream();

            //调用oss方法实现上传
            ossClient.putObject(bucketName, filePath, inputStream);
            url = "https://" + bucketName + "." + endpoint + "/" + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient。
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }

    private String generateFileName(String filename, @Nullable String dirName) {
        //使用uuid给文件重新命名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        //根据日期对文件进行分类,使文件上传到指定的目录下
        //需要分情况判断,如果dirname为空,输出结果会被加上一个null
        if (StringUtils.hasLength(dirName)) {
            return dirName + '/' + new DateTime().toString("yyyy/MM/dd/") + filename;
        } else {
            return new DateTime().toString("yyyy/MM/dd/") + filename;
        }
    }
}
