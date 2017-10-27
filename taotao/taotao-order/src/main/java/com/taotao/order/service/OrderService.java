package com.taotao.order.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.order.pojo.OrderInfo;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderService {

	TaotaoResult createOrder(OrderInfo orderInfo);
	TaotaoResult queryOrder(Long uid,Integer page,Integer rows);
}
