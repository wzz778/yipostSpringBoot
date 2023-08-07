package com.wzz.yipost.controller;

import com.wzz.yipost.pojo.Result;
import com.wzz.yipost.utils.AliOSSUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j//日志log的注解
//@RequestMapping("/upload")
@RestController
@CrossOrigin
@Api(tags = "文件")
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    /**
     * 头像上传
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result upload( MultipartFile image) throws IOException {
        log.info("文件上传, 文件名: {}", image.getOriginalFilename());

        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成,文件访问的url: {}", url);

        return Result.success(url);
    }
}
