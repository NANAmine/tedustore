package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.Orders;
import cn.tedu.store.bean.User;

public interface OrdersMapper {


	/**
	 * 插入订单信息
	 * @param order
	 */
	void insertOrder(Orders order);

	/**
	 * 插入订单详情
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);

	/**
	 * 查询订单
	 * @param userId
	 * @return
	 */
	List<Orders> selectOrderItems(Integer userId);
	
	/**
	 * 修改支付状态为已支付
	 * @param orderId
	 */
	void updateStatus(Integer orderId);

	void pay(Integer orderId);
	
	
	List<Order> getOrderByUserId(Integer userId);
	 List<OrderItem> getOrderItemByOrderId(Integer orderId);
	 void confirmReceived(Integer orderId);
	 void cancelOrder(Integer orderId);
}
