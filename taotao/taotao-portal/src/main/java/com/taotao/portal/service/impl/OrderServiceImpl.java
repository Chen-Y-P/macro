package com.taotao.portal.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.OrderInfo;
import com.taotao.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单管理
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	@Value("${ORDER_QUERY_URL}")
	private String ORDER_QUERY_URL;

	@Override
	public TaotaoResult createOrder(OrderInfo orderInfo) {
		//先把orderInfo转换成json数据
		String json = JsonUtils.objectToJson(orderInfo);
		//调用订单系统的服务
		String string = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, json);
		//把string转换成TaotaoResult对象
		TaotaoResult result = TaotaoResult.format(string);
		
		return result;
	}

	@Override
	public Map getOrderByUid(Integer page, Integer rows, Long uid) {
		String url = ORDER_BASE_URL+ORDER_QUERY_URL+"/"+uid+"/"+page+"/"+rows;
		String json = HttpClientUtil.doGet(url);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, Map.class);
		return (Map) taotaoResult.getData();
	}

}
