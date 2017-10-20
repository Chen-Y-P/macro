package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public TaotaoResult insertContent(TbContent content) {
		try {
			//补全字段
			content.setUpdated(new Date());
			content.setCreated(new Date());
			//插入数据
			contentMapper.insert(content);
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return TaotaoResult.ok();
	}

	@Override
	public EasyUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId) {
		PageHelper.startPage(page,rows);
		TbContentExample example = new TbContentExample();
		if(categoryId!=0){
			example.createCriteria().andCategoryIdEqualTo(categoryId);
		}
		List<TbContent> tbContents = contentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
		EasyUIDataGridResult result = new EasyUIDataGridResult(pageInfo.getTotal(),pageInfo.getList());
		return result;
	}

}
