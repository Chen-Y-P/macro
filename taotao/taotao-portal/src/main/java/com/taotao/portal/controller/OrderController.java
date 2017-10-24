package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.Item;
import com.taotao.portal.pojo.OrderInfo;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.OrderService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品订单管理
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/order-cart")
	public String showOrderCart(HttpServletRequest request,Model model) {
		List<Item> cartList= cartService.getCatItemList(request);
		//把物流信息和购物车商品列表传递给jsp
		model.addAttribute("cartList",cartList);
		//返回逻辑视图
		return "order-cart";
	}
	
	@RequestMapping("/create")
	public String createOrder(OrderInfo orderInfo, HttpServletRequest request, Model model) {
		//取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		//补全orderIn的属性
		orderInfo.setUserId(user.getId());
		orderInfo.setBuyerNick(user.getUsername());
		//调用service创建订单
		TaotaoResult result = orderService.createOrder(orderInfo);
		if (result.getStatus() == 200) {
			//把订单号传递个页面
			model.addAttribute("orderId", result.getData());
			model.addAttribute("payment", orderInfo.getPayment());
			model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
			return "success";
		}
		model.addAttribute("message", result.getMsg());
		return "error/exception";
	}
}
