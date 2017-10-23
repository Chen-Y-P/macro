package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

import java.util.List;

/**
 * 内容管理
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 新增内容
     */
    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult saveContent(TbContent content) {
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }

    /**
     * 分页查询某个分类下的内容
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "30") Integer rows,
                                               Long categoryId) {
        return contentService.getContentList(page,rows,categoryId);
    }

    /**
     * 批量删除内容
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContent(@RequestParam("ids") List<Long> ids){
        return contentService.deleteContent(ids);
    }

    /**
     * 更新内容
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateContent(TbContent tbContent){
        return contentService.updateContent(tbContent);
    }
}
