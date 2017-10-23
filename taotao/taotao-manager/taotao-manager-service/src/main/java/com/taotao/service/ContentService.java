package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	EasyUIDataGridResult getContentList(Integer page,Integer rows,Long categoryId);
	TaotaoResult deleteContent(List<Long> ids);
	TaotaoResult updateContent(TbContent tbContent);
}
