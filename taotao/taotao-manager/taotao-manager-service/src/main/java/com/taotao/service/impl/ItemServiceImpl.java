package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.taotao.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;
	
	@Autowired
	TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) { 
		
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		//添加条件
		List<TbItem> list = itemMapper.selectByExample(example);
		//取total
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		
		//创建返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult(total, list);
		
		return result;
	}

	@Override
	public TaotaoResult addItem(TbItem item, TbItemDesc itemDesc, String itemParams) {
		try {
			//生成商品id
			//可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
			Long itemId = IDUtils.genItemId();
			//补全不完整的字段
			item.setId(itemId);
			item.setStatus((byte) 1);
			Date date = new Date();
			item.setCreated(date);
			item.setUpdated(date);
			//把数据插入到商品表
			itemMapper.insert(item);
			//添加商品描述
			itemDesc.setItemId(itemId);
			itemDesc.setCreated(date);
			itemDesc.setUpdated(date);
			//把数据插入到商品描述表
			itemDescMapper.insert(itemDesc);
			
			//把商品的规格参数插入到tb_item_param_item中
			TbItemParamItem itemParamItem = new TbItemParamItem();
			itemParamItem.setItemId(itemId);
			itemParamItem.setParamData(itemParams);
			itemParamItem.setCreated(date);
			itemParamItem.setUpdated(date);
			itemParamItemMapper.insert(itemParamItem);
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult updateItem(TbItem item, String desc, String itemParams) {
		try {
			Date date = new Date();
			item.setUpdated(date);
			Long itemId = item.getId();
			//更新item信息
			itemMapper.updateByPrimaryKeySelective(item);
			//更新itemDesc信息
			itemDescMapper.deleteByPrimaryKey(itemId);
			TbItemDesc tbItemDesc = new TbItemDesc();
			tbItemDesc.setItemId(itemId);
			tbItemDesc.setItemDesc(desc);
			tbItemDesc.setCreated(date);
			tbItemDesc.setUpdated(date);
			itemDescMapper.insert(tbItemDesc);
			//更新itemParamItem信息
			TbItemParamItemExample example = new TbItemParamItemExample();
			example.createCriteria().andItemIdEqualTo(itemId);
			itemParamItemMapper.deleteByExample(example);
			TbItemParamItem tbItemParamItem = new TbItemParamItem();
			tbItemParamItem.setItemId(itemId);
			tbItemParamItem.setCreated(date);
			tbItemParamItem.setUpdated(date);
			tbItemParamItem.setParamData(itemParams);
			itemParamItemMapper.insert(tbItemParamItem);
		} catch (Exception e) {
			e.printStackTrace();
			TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteItemByItemIds(List<Long> itemIds) {
		try {
			TbItemExample example = new TbItemExample();
			example.createCriteria().andIdIn(itemIds);
			itemMapper.deleteByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

	@Override
	public TbItemDesc getItemDesc(Long itemId) {
		return itemDescMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public TaotaoResult updateItemStatus(List<Long> itemIds, Byte status) {
		try {
			TbItemExample example = new TbItemExample();
			example.createCriteria().andIdIn(itemIds);
			TbItem tbItem = new TbItem();
			tbItem.setStatus(status);
			itemMapper.updateByExampleSelective(tbItem,example);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
