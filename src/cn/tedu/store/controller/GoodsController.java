package cn.tedu.store.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	GoodsService goodsService;
	
	public GoodsController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(Integer goodsId, Integer categoryId, Map<String, Object> map) {
		map = goodsService.showGoodsInfo(map, categoryId, goodsId);
		return "product_details";
	}

}