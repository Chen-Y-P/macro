package com.taotao.portal.controller;

import com.taotao.common.pojo.SearchResult;
import com.taotao.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品搜索
 * 搜索：关键字搜索（标题、卖点、分类名称、产品描述综合搜索）
 * 筛选：分类、品牌、价格区间
 * 排序：按销量、按价格、按新品
 * 商品导入solr中（rest工程中）
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	/**
	 * 关键字搜索
	 * @param queryString 搜索的关键字
	 * @param page 页数
	 */
	@RequestMapping("/search")
	public String search(@RequestParam("q") String queryString,
			@RequestParam(defaultValue="1") Long page, Model model) throws Exception {
		//解决乱码问题
//		queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
		SearchResult searchResult = searchService.search(queryString, page);
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", searchResult.getPageCount());
		model.addAttribute("itemList", searchResult.getItemList());
		model.addAttribute("page", searchResult.getPage());
		return "search";
	}
}
