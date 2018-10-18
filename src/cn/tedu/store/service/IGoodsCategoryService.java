package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {

	List<GoodsCategory> getGoodsCategoryByParentId(int parentId, int offset, int count);

	GoodsCategory getGoodsCategoryById(int id);
}
