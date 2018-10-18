package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.bean.GoodsVO;

public interface IGoodsService {

	List<GoodsVO> getGoodsVOByCategoryId(Integer categoryId, Integer offset, Integer count);

	Goods getGoodsById(Integer id);
	
	List<GoodsPicture> getGoodsPictureByGoodsId(Integer GoodsId);
}