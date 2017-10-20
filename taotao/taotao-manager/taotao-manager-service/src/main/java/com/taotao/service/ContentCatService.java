package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;

public interface ContentCatService {

	List<TreeNode> getContentCatList(long parentId);
	TaotaoResult createContentCat(long parentId, String name);
	TaotaoResult updateContentCat(long id, String name);
	TaotaoResult deleteContentCat(long parentId, long id);
}
