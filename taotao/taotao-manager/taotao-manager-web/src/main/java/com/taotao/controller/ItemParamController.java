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

	/**
	 * 检测该规格参数是否已经存在
	 * @param cid 规格参数对应商品分类的id
	 */
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult checkItemParam(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.checkParam(cid);
		return result;
	}

	/**
	 * 保存规格参数
	 * @param cid 参数对于商品分类
	 * @param paramData 参数信息
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult addItemParam(@PathVariable Long cid, String paramData) {
		TaotaoResult result = itemParamService.addItemParam(cid, paramData);
		return result;
	}

	/**
	 * 获取指定分类的规格参数
	 * @param cid 商品的分类
	 */
	@RequestMapping("/cid/{cid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}

	/**
	 * 分类查询商品分类规格参数模块
	 * @return dataGrid需要的数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
												 @RequestParam(defaultValue = "30") Integer rows){
		return itemParamService.getItemParamList(page,rows);
	}

	/**
	 * 批量删除规格参数
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteItemParam(@RequestParam("ids") List<Long> ids){
		return itemParamService.deleteItemParam(ids);
	}
}
