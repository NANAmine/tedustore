package cn.tedu.store.bean;

public class OrderItem {

	Integer id;
	Integer userId;
	Integer goodsId;
	String image;
	String title;
	Double price;
	Integer count;
	String spec;
	Integer orderId;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer userId, Integer goodsId, String image, String title, Double price,
			Integer count, String spec, Integer orderId) {
		super();
		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.spec = spec;
		this.orderId = orderId;
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

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", userId=" + userId + ", goodsId=" + goodsId + ", image=" + image + ", title="
				+ title + ", price=" + price + ", count=" + count + ", spec=" + spec + ", orderId=" + orderId + "]";
	}
	
	

	
	
}
