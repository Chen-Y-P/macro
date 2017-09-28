package com.macro.ssm.service.impl;

import com.macro.ssm.po.PictureResult;
import com.macro.ssm.service.PictureUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by zhenghong on 2017/9/27.
 */
@Service
public class PictureUploadServiceImpl implements PictureUploadService {
    @Value("${HTTP_IMAGE_PATH}")
    private String HTTP_IMAGE_PATH;
    public PictureResult uploadFile(MultipartFile picFile, String saveDirectoryPath) {
        PictureResult result = new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        //上传到图片服务器
        try {
            //上传文件到指定路径下
            picFile.transferTo(new File(saveDirectoryPath+picFile.getOriginalFilename()));
            //把url响应给客户端
            result.setError(0);
            result.setUrl(HTTP_IMAGE_PATH+picFile.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;
    }
}
