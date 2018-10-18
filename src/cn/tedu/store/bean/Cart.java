package cn.tedu.store.bean;

public class Cart {

	public Cart() {}
	
	private Integer id;//订单编号
	private Integer goodsId;//商品编号
	private Integer userId;//用户号
	private Integer count;//商品数量
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", goodsId=" + goodsId + ", userId=" + userId + ", count=" + count + "]";
	}
	
}
