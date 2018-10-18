package cn.tedu.store.bean;

import java.util.Date;

public class Order {

	Integer id;
	Integer uesrId;
	Integer addressId;
	Double payment;
	Integer paymentStatus;
	Integer shippingStatus;
	Date tradeTime;
	Date receipTime;
	Date deliverTime;
	Date handoverTime;
	
	
	
	public Order() {
		super();
	}



	public Order(Integer id, Integer uesrId, Integer addressId, Double payment, Integer paymentStatus,
			Integer shippingStatus, Date tradeTime, Date receipTime, Date deliverTime, Date handoverTime) {
		super();
		this.id = id;
		this.uesrId = uesrId;
		this.addressId = addressId;
		this.payment = payment;
		this.paymentStatus = paymentStatus;
		this.shippingStatus = shippingStatus;
		this.tradeTime = tradeTime;
		this.receipTime = receipTime;
		this.deliverTime = deliverTime;
		this.handoverTime = handoverTime;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getUesrId() {
		return uesrId;
	}



	public void setUesrId(Integer uesrId) {
		this.uesrId = uesrId;
	}



	public Integer getAddressId() {
		return addressId;
	}



	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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



	public Date getTradeTime() {
		return tradeTime;
	}



	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}



	public Date getReceipTime() {
		return receipTime;
	}



	public void setReceipTime(Date receipTime) {
		this.receipTime = receipTime;
	}



	public Date getDeliverTime() {
		return deliverTime;
	}



	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}



	public Date getHandoverTime() {
		return handoverTime;
	}



	public void setHandoverTime(Date handoverTime) {
		this.handoverTime = handoverTime;
	}



	@Override
	public String toString() {
		return "Order [id=" + id + ", uesrId=" + uesrId + ", addressId=" + addressId + ", payment=" + payment
				+ ", paymentStatus=" + paymentStatus + ", shippingStatus=" + shippingStatus + ", tradeTime=" + tradeTime
				+ ", receipTime=" + receipTime + ", deliverTime=" + deliverTime + ", handoverTime=" + handoverTime
				+ "]";
	}

	
	
}
