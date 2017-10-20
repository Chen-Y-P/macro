package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

import java.util.List;

/**
 * 商品管理
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 查询商品
	 * @param itemId 商品的id
	 * @return 商品信息
	 */
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable(value="itemId") Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	/**
	 * 分页查询商品列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="30") Integer rows) {
		//调用service查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		//返回结果
		return result;
		
	}

	/**
	 * 新增商品
	 * @param item 商品信息
	 * @param desc 商品详情(html)
	 * @param itemParams 商品的规格参数信息(json)
	 * @return 响应结果
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult addItem(TbItem item, String desc, String itemParams) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		TaotaoResult result = itemService.addItem(item, itemDesc, itemParams);
		return result;
	}

	/**
	 * 修改商品
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateItem(TbItem item, String desc, String itemParams){
		TaotaoResult taotaoResult = itemService.updateItem(item, desc, itemParams);
		return taotaoResult;
	}

	/**
	 * 获取商品的详情
	 */
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDesc(@PathVariable Long itemId){
		TbItemDesc itemDesc = itemService.getItemDesc(itemId);
		return TaotaoResult.ok(itemDesc);
	}

	/**
	 * 批量删除商品
	 * @param ids 商品id
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteItemByItemIds(@RequestParam("ids") List<Long> ids){
		TaotaoResult taotaoResult = itemService.deleteItemByItemIds(ids);
		return taotaoResult;
	}

	/**
	 * 批量下架商品
	 */
	@RequestMapping(value = "/outstock",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult outStockItems(@RequestParam("ids") List<Long> ids){
		TaotaoResult taotaoResult = itemService.updateItemStatus(ids, new Byte("2"));
		return taotaoResult;
	}

	/**
	 * 批量上架商品
	 */
	@RequestMapping(value = "/instock",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult inStockItems(@RequestParam("ids") List<Long> ids){
		TaotaoResult taotaoResult = itemService.updateItemStatus(ids, new Byte("1"));
		return taotaoResult;
	}
}
