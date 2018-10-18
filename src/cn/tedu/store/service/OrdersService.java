package cn.tedu.store.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.Orders;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrdersMapper;

@Service
public class OrdersService implements IOrdersService{

	@Autowired
	private OrdersMapper orderMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CartMapper cartMapper;

	/**
	 * 从购物车中确认订单提交
	 */
	@Override
	public Integer addOrder(Integer userId, List<Cart> carts,HttpSession session) {
		Orders order = new Orders();
		order.setUserId(userId);
		System.out.println(order);
		orderMapper.insertOrder(order);
		Integer orderId = order.getId();
		System.out.println(userId);
		OrderItem orderItem = new OrderItem();
		List<OrderItem> listoi=new ArrayList<OrderItem>();
		for (Cart c : carts) {  
			Goods goods=goodsMapper.getGoodsById(c.getGoodsId());
			orderItem.setUserId(userId);
			orderItem.setGoodsId(goods.getId());
			orderItem.setImage(goods.getImage());
			orderItem.setTitle(goods.getTitle());
			orderItem.setPrice(goods.getPrice());
			orderItem.setCount(c.getCount());
			orderItem.setOrderId(orderId);
			System.out.println(orderItem);
			orderMapper.insertOrderItem(orderItem);
			listoi.add(orderItem);
			cartMapper.deleteCart(c.getId());
			
		}
		session.setAttribute("listoi", listoi);
		return orderId;
		
	}

	/**
	 * 更新订单状态
	 */
	@Override
	public void updateStatus(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询订单详情
	 */
	@Override
	public List<Orders> selectOrderItems(Integer userId) {
		return orderMapper.selectOrderItems(userId);
	}

	/**
	 * 删除订单
	 */
	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	public void pay(Integer orderId) {
		 orderMapper.pay(orderId);
	}
	@Override
	public Map<String , Object>  showOrderItem(Integer userId, Map<String , Object> map) {
		List<Order> orders = orderMapper.getOrderByUserId(userId);
		map.put("orders", orders);
		
		List<List<OrderItem>> allOrderItems = new ArrayList<List<OrderItem>>();
		for (Order order : orders) {
			List<OrderItem> orderItems = orderMapper.getOrderItemByOrderId(order.getId());
			allOrderItems.add(orderItems);
		}
		map.put("allOrderItems", allOrderItems);
		return map;
	}

	public void cancelOrder(Integer orderId) {
		orderMapper.cancelOrder(orderId);
	}

	@Override
	public void confirmReceived(Integer orderId) {
		orderMapper.confirmReceived(orderId);
		
	}

}
