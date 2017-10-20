package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

public interface ItemParamService {

	TaotaoResult checkParam(long cid);
	TaotaoResult addItemParam(long cid, String template);
	TaotaoResult getItemParamByCid(long cid);
	EasyUIDataGridResult getItemParamList(Integer page,Integer rows);
	TaotaoResult deleteItemParam(List<Long> ids);
}
