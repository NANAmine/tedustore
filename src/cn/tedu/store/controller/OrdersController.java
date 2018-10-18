package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVO;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.IOrdersService;


@Controller
@RequestMapping("/order")
public class OrdersController   {

	@Autowired
	private ICartService cartService;
	@Autowired
	private IGoodsService goodsService;
	
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private IOrdersService orderService;

	
	@RequestMapping("/showPayment.do")
	public String showPayment(Integer orderId) {
		return "payment";
	}
	@RequestMapping("confirmReceived.do")
	public String confirmReceived(Integer orderId) {
		orderService.confirmReceived(orderId);
		return "redirect:showOrderItem.do";
	}
	/**
	 * 显示订单页面
	 * @param session
	 * @param ids
	 * @param modelMap
	 * @return
	 */
	/*@RequestMapping("/showOrderItem.do")
	public String showOrder(HttpSession session, Integer[] id, ModelMap modelMap) {
		User user=(User)session.getAttribute("user");
		List<Cart> listCarts = cartService.getCarts(user.getId());
		System.out.println(listCarts);
		
		List<Goods> listGoods=new ArrayList<Goods>();
		for (Cart c : listCarts) {
			listGoods.add(goodsService.getGoodsById(c.getId()));
			
		}
		session.setAttribute("listCarts", listCarts);
		modelMap.addAttribute("listCarts", listCarts);
		modelMap.addAttribute("listGoods", listGoods);
		List<Address> addresses = addressService.getAllAddressByUid(user.getId());
		modelMap.addAttribute("addresses", addresses);
		session.setAttribute("addresses", addresses);
		return "orders";
	}*/
	
	@RequestMapping("showOrderItem.do")
	public String showOrderItem(HttpSession session, Map<String ,Object> map) {
		User user = (User) session.getAttribute("user");
		Integer userId = user.getId();
		map = orderService.showOrderItem(userId, map);
		return "orders";
	}
	
	
	@RequestMapping("/showAddress.do")
	public String showAddress(HttpSession session, Integer[] id, ModelMap modelMap) {
		User user=(User)session.getAttribute("user");
		List<Cart> listCarts = cartService.getCarts(user.getId());
		System.out.println(listCarts);
		List<Goods> listGoods=new ArrayList<Goods>();
		for (Cart c : listCarts) {
			
			listGoods.add(goodsService.getGoodsById(c.getId()));
			
		}
		session.setAttribute("listCarts", listCarts);
		modelMap.addAttribute("listCarts", listCarts);
		modelMap.addAttribute("listGoods", listGoods);
		List<Address> addresses = addressService.getAllAddressByUid(user.getId());
		modelMap.addAttribute("addresses", addresses);
		session.setAttribute("addresses", addresses);
		return "addressAdmin";
	}
	
	/**
	 * 生成订单并跳转支付页面
	 * @param session
	 * @return
	 */
	//@SuppressWarnings("unchecked")
	@RequestMapping("/showOrderConfirm.do")
	public String payment(String ids,HttpSession session,Map<String,Object> map) {
		String[] strArray = ids.split(",");
		List<Integer> iids = new ArrayList<Integer>();
		for(int i=0;i<strArray.length;i++) {
			iids.add(Integer.parseInt(strArray[i]));
		}
		
		List<CartVO> listCartVO = new  ArrayList<CartVO>();
		List<Address> listAddress = new ArrayList<Address>();
		
		User user=(User)session.getAttribute("user");
		// (List<CartVo>)session.getAttribute("cartVos")
		List<Cart> listCart=new ArrayList<Cart>();
		for (Integer i : iids) {
			listCart.add(cartService.getCartsByid(i));
			listCartVO.add(cartService.getcartVOById(i));
			System.out.println(cartService.getCartsByid(i));
		}
		
		listAddress = addressService.getAllAddressByUid(user.getId());
		
		map.put("listCartVO", listCartVO);
		map.put("listAddress", listAddress);
		Integer orderId = orderService.addOrder(user.getId(),listCart,session);
		session.setAttribute("orderId", orderId);
		return "orderConfirm";
	}
	
	@RequestMapping("pay.do")
	public String pay(HttpSession session,Integer orderId) {
		System.out.println("aaaaaaaaaaaaaa\nadsf");
		orderId = (Integer)session.getAttribute("orderId");
		orderService.pay(orderId);
		return "pay_success";
	}
	
	@RequestMapping("cancelOrder.do")
	public String cancelOrder(Integer orderId) {
		orderService.cancelOrder(orderId);
		return "redirect:showOrderItem.do";
	}

}