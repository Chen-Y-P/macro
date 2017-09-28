package com.macro.ssm.service;

import com.macro.ssm.po.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhenghong on 2017/9/27.
 */
public interface PictureUploadService {
    PictureResult uploadFile(MultipartFile picFile, String saveDirectoryPath);
}
