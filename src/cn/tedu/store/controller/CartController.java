package cn.tedu.store.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVO;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsService;

// 购物车相关的功能
@Controller
@RequestMapping("/cart")
public class CartController implements Serializable {
	
	@Autowired
	CartService cartSerivce;
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(Integer goodsid, Integer count, HttpSession session) {
		Cart cart = new Cart();
		cart.setCount(count);
		cart.setGoodsId(goodsid);
		User user=(User)session.getAttribute("user");
		cart.setUserId(user.getId());
		cartSerivce.addCart(cart);
		return new ResponseResult<Void>(1, "加入购物车成功！");
	}
	
	@RequestMapping("/showCart.do")
	public String showCart(Map<String, Object>map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<CartVO> listCartVo = cartSerivce.getGoodsByUseridInCart(user.getId());
		map.put("listCartVo", listCartVo);
		return "cart";
	}
	
	
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id, Map<String, Object>map, HttpSession session) {
		cartSerivce.deleteById(id);
		return showCart(map, session);
	}
	
	@RequestMapping("/deleteByBatch.do")
	public String deleteByBatch(String ids, Map<String, Object>map, HttpSession session) {
		String[] strArray = ids.split(",");
		List<Integer> temp_ids = new ArrayList<Integer>();

		for(int i=0;i<strArray.length;i++) {
			temp_ids.add(Integer.parseInt(strArray[i]));
		}
		System.out.println(temp_ids);
		cartSerivce.deleteByBatch(temp_ids);
		return showCart(map, session);
	}

	@RequestMapping("/updateCountById.do")
	public void updateCountById(Integer id, Integer count) {
		cartSerivce.updateCountById(id, count);
	}
	

}