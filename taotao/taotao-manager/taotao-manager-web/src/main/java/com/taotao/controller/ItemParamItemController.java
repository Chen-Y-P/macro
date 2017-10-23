package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品的详情参数管理
 */
@Controller
public class ItemParamItemController {

	@Autowired
	private ItemParamItemService itemParamItemService;

	/**
	 * 获取某个商品的规格参数
	 * @param itemId 商品的id
	 * @return 逻辑视图
	 */
	@RequestMapping("/showParam/{itemId}")
	public String showParam(@PathVariable Long itemId, Model model) {
		String string = itemParamItemService.getItemParamDataById(itemId);
		model.addAttribute("html", string);
		return "item-param";
	}

	/**
	 * 获取某个商品的规格参数（json格式数据）
	 */
	@RequestMapping("/item/param/item/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParamItem(@PathVariable Long itemId){
		TbItemParamItem itemParamItem = itemParamItemService.getItemParamById(itemId);
		return TaotaoResult.ok(itemParamItem);
	}
	
}
