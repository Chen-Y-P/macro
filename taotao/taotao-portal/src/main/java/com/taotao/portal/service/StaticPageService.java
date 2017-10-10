package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by zhenghong on 2017/10/10.
 */
public interface StaticPageService {
    TaotaoResult genItemHtml(Long itemId) throws Exception;
}
