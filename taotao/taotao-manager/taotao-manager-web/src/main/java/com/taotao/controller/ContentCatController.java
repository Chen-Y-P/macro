package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ContentCatService;

/**
 * 内容分类管理
 */
@Controller
@RequestMapping("/content/category")
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;

    /**
     * 根据父分类的id获取内容分类
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<TreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<TreeNode> list = contentCatService.getContentCatList(parentId);
        return list;
    }

    /**
     * 创建一个内容分类
     *
     * @param parentId 父分类的id
     * @param name     分类名称
     */
    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCat(Long parentId, String name) {
        TaotaoResult result = contentCatService.createContentCat(parentId, name);
        return result;
    }

    /**
     * 修改内容分类信息
     *
     * @param id   内容分类的id
     * @param name 内容分类的名称
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateContentCat(Long id, String name) {
        return contentCatService.updateContentCat(id, name);
    }

    /**
     * 删除内容分类
     * @param parentId 内容分类的父id
     * @param id 要删除分类的id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContentCat(Long parentId, Long id) {
        return contentCatService.deleteContentCat(parentId, id);
    }
}
