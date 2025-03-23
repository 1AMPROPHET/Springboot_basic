package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}, {}, {}", username, age, image);
        // 获取原始名称
        String originalFilename = image.getOriginalFilename();
        log.info(originalFilename);
        // 截取后缀名
        int index = originalFilename.lastIndexOf(".");
        String extName = originalFilename.substring(index);
        String newFileName = UUID.randomUUID() + extName;

        // 将文件保存在指定位置
        image.transferTo(new File("D:\\workspace\\file\\" + newFileName));
        log.info("success: {}", newFileName);
        return Result.success();
    }
}
