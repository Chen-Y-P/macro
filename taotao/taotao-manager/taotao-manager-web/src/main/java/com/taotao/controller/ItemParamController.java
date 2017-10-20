package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;

import java.util.List;

/**
 * 规格参数模板控制器
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult checkItemParam(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.checkParam(cid);
		return result;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult addItemParam(@PathVariable Long cid, String paramData) {
		TaotaoResult result = itemParamService.addItemParam(cid, paramData);
		return result;
	}
	
	@RequestMapping("/cid/{cid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}

	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
												 @RequestParam(defaultValue = "30") Integer rows){
		return itemParamService.getItemParamList(page,rows);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteItemParam(@RequestParam("ids") List<Long> ids){
		return itemParamService.deleteItemParam(ids);
	}
}
