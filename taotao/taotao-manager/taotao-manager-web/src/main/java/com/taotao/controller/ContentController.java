package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult saveContent(TbContent content) {
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "30") Integer rows,
                                               Long categoryId) {
        return contentService.getContentList(page,rows,categoryId);
    }
}
