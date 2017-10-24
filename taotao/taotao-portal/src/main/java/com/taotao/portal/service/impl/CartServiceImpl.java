package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.Item;
import com.taotao.portal.service.CartService;

/**
 * 购物车服务
 */
@Service
public class CartServiceImpl implements CartService {

	@Value("${CAT_COOKIE_EXPIRE}")
	private Integer CAT_COOKIE_EXPIRE;
	@Autowired
	private ItemService itemService;

	@Override
	public TaotaoResult addCartItem(long itemId, Integer itemNum, HttpServletRequest request, HttpServletResponse response) {

		// 1、接收controller传递过来的参数：商品id
		// 2、从cookie中购物车商品列表
		List<Item> list = getCatItemList(request);
		boolean flag = false;
		// 3、从商品列表中查询列表是否存在此商品
		for (Item item : list) {
			// 4、如果存在商品的数量加上参数中的商品数量
			if (item.getId() == itemId) {
				flag = true;
				item.setCartItemNum(item.getCartItemNum() + itemNum);
				break;
			}
		}
		// 5、如果不存在，调用rest服务，根据商品id获得商品数据。
		if (!flag) {
			Item item = itemService.getItemById(itemId);
			item.setCartItemNum(itemNum);
			// 6、把商品数据添加到列表中
			list.add(item);
		}
		// 7、把购物车商品列表写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list), CAT_COOKIE_EXPIRE,
				"utf-8");
		// 8、返回TaotaoResult
		return TaotaoResult.ok();
	}

	/**
	 * 取购物车商品列表
	 * <p>Title: getCatItemList</p>
	 * <p>Description: </p>
	 * @param request
	 * @return
	 * @see com.taotao.portal.service.CartService#getCatItemList(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public List<Item> getCatItemList(HttpServletRequest request) {
		try {
			//从cookie中取商品列表
			String json = CookieUtils.getCookieValue(request, "TT_CART", true);
			//把json转换成java对象
			List<Item> list = JsonUtils.jsonToList(json, Item.class);

			return list==null?new ArrayList<Item>():list;

		} catch (Exception e) {
			return new ArrayList<Item>();
		}
	}

	/**
	 * 更新购物车商品数量
	 * <p>Title: updateItemNum</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemNum
	 * @return
	 * @see com.taotao.portal.service.CartService#updateItemNum(long, int,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public TaotaoResult updateItemNum(long itemId, int itemNum, 
			HttpServletRequest request, HttpServletResponse response) {
		//从cookie中把商品列表取出来
		List<Item> list = getCatItemList(request);
		//遍历列表找商品
		for (Item item : list) {
			if (item.getId().longValue() == itemId) {
				//更新商品数量
				item.setCartItemNum(itemNum);
				break;
			}
		}
		//把购物车商品列表写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list), CAT_COOKIE_EXPIRE,
				"utf-8");

		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
		// 1、接收商品id
		// 2、从cookie中取购物车商品列表
		List<Item> itemList = getCatItemList(request);
		// 3、找到对应id的商品
		for (Item cartItem : itemList) {
			if (cartItem.getId() == itemId) {
				// 4、删除商品。
				itemList.remove(cartItem);
				break;
			}
		}
		// 5、再重新把商品列表写入cookie。
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), CAT_COOKIE_EXPIRE, true);
		// 6、返回成功
		return TaotaoResult.ok();
	}

}
