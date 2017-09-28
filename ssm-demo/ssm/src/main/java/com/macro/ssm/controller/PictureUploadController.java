package com.macro.ssm.controller;

import com.macro.ssm.po.PictureResult;
import com.macro.ssm.service.PictureUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhenghong on 2017/9/27.
 */
@Controller
public class PictureUploadController {
    @Autowired
    private PictureUploadService pictureUploadService;
    @Value("${UPLOAD_IMAGE_PATH}")
    private String UPLOAD_IMAGE_PATH;
    @RequestMapping(value = "/uploadPic",method = RequestMethod.POST)
    @ResponseBody
    public PictureResult uploadFile(@RequestPart MultipartFile uploadFile,HttpServletRequest request){
        String saveDirectoryPath = request.getServletContext().getRealPath(UPLOAD_IMAGE_PATH);
        return pictureUploadService.uploadFile(uploadFile,saveDirectoryPath);
    }

}
