package com.taotao.portal.controller;

import com.taotao.portal.pojo.FloorItem;
import com.taotao.portal.pojo.QuickReportItem;
import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页展示
 */
@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;

//	@RequestMapping("/index")
//	public String showIndex(Model model) {
//		//首页大广告为categoryId固定为89。
//		List<TbContent> list = contentService.getContentList(89);
//		List<Map> resultList = new ArrayList<>();
//		for (TbContent tbContent : list) {
//			Map item = new HashMap<>();
//			item.put("src", tbContent.getPic());
//			item.put("width", 670);
//			item.put("height", 240);
//			item.put("srcB", tbContent.getPic2());
//			item.put("widthB", 550);
//			item.put("heightB", 240);
//			item.put("href", tbContent.getUrl());
//			item.put("alt", tbContent.getTitle());
//			resultList.add(item);
//		}
//		String json = JsonUtils.objectToJson(resultList);
//		model.addAttribute("dataMSlide", json);
//		return "index";
//	}

	/**
	 * 返回首页的静态数据
	 */
	@RequestMapping("/index")
	public String showIndex(Model model) {
		String dataMSlide = contentService.getJsonContent("json/DATA_MSlide.json");
		model.addAttribute("dataMSlide", dataMSlide);
		String dataMScroll = contentService.getJsonContent("json/DATA_MScroll.json");
		model.addAttribute("dataMScroll", dataMScroll);
		String dataTabs = contentService.getJsonContent("json/DATA_Tabs.json");
		model.addAttribute("dataTabs", dataTabs);
		String dataFSlideF8 = contentService.getJsonContent("json/DATA_FSlideF8.json");
		model.addAttribute("dataFSlideF8", dataFSlideF8);
		String dataTopRight = contentService.getJsonContent("json/DATA_TopRight.json");
		model.addAttribute("dataTopRight", dataTopRight);
		List<FloorItem> floorItemList = contentService.getFloorItemList();
		model.addAttribute("floorItemList",floorItemList);
		List<QuickReportItem> quickReportItemList = contentService.getQuickReportItemList();
		model.addAttribute("quickReportItemList",quickReportItemList);
		return "index";
	}

	/**
	 * jsonp返回商品分类静态数据
	 */
	@RequestMapping(value = "/item/cat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String showCate(String callback){
		String dataCategory = contentService.getJsonContent("json/DATA_Category.json");
		return callback+"("+dataCategory+");";
	}
}
