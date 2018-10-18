package cn.tedu.store.bean;

import java.io.Serializable;

/**
 * 显示商品信息时，绝大部分情况下，
 * 只需要商品的3～5个属性，不需要完整的商品信息（17个）
 * 此时，可再封装出一个简化的bean，可称作值对象/显示对象
 * 
 * 特定模块查询结果，会涉及多个bean表(例如 可能会显示)时，
 * 可将这些需要显示的字段，合成到一个特殊的VO中
 * 好处：一条sql语句的结果 对应 一个VO类型
 */
public class GoodsVO implements Serializable {
	private Integer id;
	private Integer categoryId;  //此字段可用于做推荐
	private String title;
	private Double price;
	private String image;
	
	public GoodsVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GoodsVO [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", price=" + price + ", image="
				+ image + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}

/*
 *另一种bean属性简化方式：使用Map，来存储关心的字段名和字段名
 *一般用于生成报表时 
 */
