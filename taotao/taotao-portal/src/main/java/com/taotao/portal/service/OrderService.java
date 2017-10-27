package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.OrderInfo;

import java.util.Map;

public interface OrderService {

	TaotaoResult createOrder(OrderInfo orderInfo);
	Map getOrderByUid(Integer page,Integer rows,Long uid);
}
