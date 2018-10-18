package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;

public interface GoodsMapper {
	/**
	 * 获得某个id商品的所有详细信息
	 * @param id
	 * @return
	 */
	Goods getGoodsById(Integer goodsId);
	
	/**
	 * 获得某个类别下 多个商品的信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsVO> getGoodsVOByCategoryId(@Param("categoryId") Integer categoryId,@Param("offset") Integer offset,@Param("count")Integer count);

	List<GoodsPicture> getGoodsPicturesByGoodsId(Integer goodsId);
	
	List<GoodsSpecVO> getGoodsSpecVOByGoodsId(Integer goodsId);
	
	List<GoodsVO> getRecommendGoodsVOByGoodsCategoryIdAndGoodsId(@Param("categoryId")Integer categoryId,@Param("goodsId")Integer goodsId);
	


}