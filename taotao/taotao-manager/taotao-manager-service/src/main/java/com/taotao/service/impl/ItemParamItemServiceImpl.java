package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.service.ItemParamItemService;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public String getItemParamDataById(long itemId) {
		//取到规格参数
		TbItemParamItem itemParamItem = getItemParamById(itemId);
		if(itemParamItem==null)return null;
		String paramData = itemParamItem.getParamData();
		//把规格参数信息转换成java对象
		List<Map> paramList = JsonUtils.jsonToList(paramData, Map.class);
		//根据list生成html
		StringBuffer sb = new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("     <tbody>\n");
		for(Map param:paramList) {
			sb.append("          <tr>\n");
			sb.append("               <th class=\"tdTitle\" colspan=\"2\">"+param.get("group")+"</th>\n");
			sb.append("          </tr>\n");
			//取规格项
			List<Map> object = (List<Map>) param.get("params");
			for (Map map : object) {
				sb.append("          <tr>\n");
				sb.append("               <td class=\"tdTitle\">"+map.get("k")+"</td>\n");
				sb.append("               <td>"+map.get("v")+"</td>\n");
				sb.append("          </tr>\n");
			}
		}
		sb.append("     </tbody>\n");
		sb.append("</table>");
		return sb.toString();
	}

	@Override
	public TbItemParamItem getItemParamById(long itemId) {

		//创建查询条件
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		//如果没有取到规格参数返回空串。
		if (null == list || list.isEmpty()) {
			return null;
		}
		//取到规格参数
		TbItemParamItem itemParamItem = list.get(0);
		return itemParamItem;
	}

}
