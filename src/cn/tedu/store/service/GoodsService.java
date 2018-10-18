package cn.tedu.store.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.ex.ParameterNullException;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<GoodsVO> getGoodsVOByCategoryId(Integer categoryId, Integer offset, Integer count) {
			
		//业务数据有效性判断
		if(categoryId==null) {
			throw new RuntimeException("商品类别不能为空");
			//TODO 封装一个异常业务
		}
		
		//业务处理
		return goodsMapper.getGoodsVOByCategoryId(categoryId,offset,count);
	}
	
	public Goods getGoodsById(Integer id) {
		return goodsMapper.getGoodsById(id);
	}
	
	@Override
	public List<GoodsPicture> getGoodsPictureByGoodsId(Integer GoodsId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String, Object> showGoodsInfo(Map<String, Object> map, Integer categoryId, Integer goodsId){
		
		if(categoryId==null || goodsId == null) {
			throw new ParameterNullException("categoryId或goodsId参数为null");
		}
		
		map.put("goods", goodsMapper.getGoodsById(goodsId));
	
		map.put("goodsPictures", goodsMapper.getGoodsPicturesByGoodsId(goodsId));
		
		map.put("goodsSpecVO", goodsMapper.getGoodsSpecVOByGoodsId(goodsId));

		map.put("recommendGoodsVO", goodsMapper.getRecommendGoodsVOByGoodsCategoryIdAndGoodsId(categoryId, goodsId));

		return map;
		
	}
	
	

}