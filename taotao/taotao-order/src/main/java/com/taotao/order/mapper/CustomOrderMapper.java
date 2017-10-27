package com.taotao.order.mapper;

import com.taotao.order.pojo.OrderInfo;

import java.util.List;

public interface CustomOrderMapper {
    List<OrderInfo> getOrderInfoByUid(Long uid);
}
