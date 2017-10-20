package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

import java.util.List;

public interface ItemService {

	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
	TaotaoResult addItem(TbItem item, TbItemDesc itemDesc, String itemParams);
	TaotaoResult updateItem(TbItem item,String desc, String itemParams);
	TaotaoResult deleteItemByItemIds(List<Long> itemIds);
	TbItemDesc getItemDesc(Long itemId);
	TaotaoResult updateItemStatus(List<Long> itemIds,Byte status);
}
