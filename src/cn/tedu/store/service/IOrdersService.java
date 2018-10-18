package cn.tedu.store.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Orders;

public interface IOrdersService {

	/**
	 * 添加提交订单
	 * @param userId
	 * @param cartVos
	 */
	Integer addOrder(Integer userId, List<Cart> carts,HttpSession session);
	
	/**
	 * 修改支付状态为已支付
	 * @param orderId
	 */
	void updateStatus(Integer orderId);
	
	/**
	 * 查询用户下的订单详情
	 * @param userId
	 * @return
	 */
	List<Orders> selectOrderItems(Integer userId);
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	void deleteOrder(Integer orderId);

	void pay(Integer orderId);

	Map<String, Object> showOrderItem(Integer userId, Map<String, Object> map);

	void cancelOrder(Integer orderId);

	void confirmReceived(Integer orderId);
}
