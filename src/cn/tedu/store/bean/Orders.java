package cn.tedu.store.bean;

import java.sql.Date;

/**
 * 订单实体类
 * @author soft01
 *
 */
public class Orders {

	private Integer id;//订单编号
	private Integer userId;//用户编号
	private Integer addresId;//地址编号
	private Double payment;//金额
	private Integer paymentStatus;//支付状态
	private Integer shippingStatus;//
	private Date tradeTamp;
	private Date recipTamp;
	private Date deliverTamp;
	private Date handoverTamp;
	
	public Orders() {}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", addresId=" + addresId + ", payment=" + payment
				+ ", paymentStatus=" + paymentStatus + ", shippingStatus=" + shippingStatus + ", tradeTamp=" + tradeTamp
				+ ", recipTamp=" + recipTamp + ", deliverTamp=" + deliverTamp + ", handoverTamp=" + handoverTamp + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAddresId() {
		return addresId;
	}

	public void setAddresId(Integer addresId) {
		this.addresId = addresId;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public Date getTradeTamp() {
		return tradeTamp;
	}

	public void setTradeTamp(Date tradeTamp) {
		this.tradeTamp = tradeTamp;
	}

	public Date getRecipTamp() {
		return recipTamp;
	}

	public void setRecipTamp(Date recipTamp) {
		this.recipTamp = recipTamp;
	}

	public Date getDeliverTamp() {
		return deliverTamp;
	}

	public void setDeliverTamp(Date deliverTamp) {
		this.deliverTamp = deliverTamp;
	}

	public Date getHandoverTamp() {
		return handoverTamp;
	}

	public void setHandoverTamp(Date handoverTamp) {
		this.handoverTamp = handoverTamp;
	}
	
}
