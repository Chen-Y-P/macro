package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.Item;
import com.taotao.portal.pojo.OrderInfo;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.LoginService;
import com.taotao.portal.service.OrderService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 商品订单管理（需要登录）
 * 1.订单信息确认
 * 2.选择收货地址
 * 3.下单（订单Iid用Redis的incr命令生成）
 * 4.订单查询（使用ResultMap映射对象、集合）
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CartService cartService;
    @RequestMapping("/order-cart")
    public String showOrderCart(HttpServletRequest request, Model model) {
        List<Item> cartList = cartService.getCatItemList(request);
        //把物流信息和购物车商品列表传递给jsp
        model.addAttribute("cartList", cartList);
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

    @RequestMapping("/my-orders")
    public String showMyOrder(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows, Model model, HttpServletRequest request) {
        String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
        TbUser tbUser = loginService.getUserByToken(token);
        Map map = orderService.getOrderByUid(page, rows, tbUser.getId());
        List<OrderInfo> orderInfoList = (List<OrderInfo>) map.get("orderInfoList");
        int total = (int) map.get("total");
        int totalPage = (total+rows-1)/total;
        model.addAttribute("orderInfoList",orderInfoList);
        model.addAttribute("totalPage",totalPage);
        return "my-orders";
    }
}
