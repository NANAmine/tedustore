package cn.tedu.store.bean;

import java.io.Serializable;

public class CartVO implements Serializable {
	private Integer id;
	private String image;
	private String title;
	private String spec;
	private Double price;
	private Integer count;
	public CartVO() {
		super();
	}
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", image=" + image + ", title=" + title + ", spec=" + spec + ", price=" + price
				+ ", count=" + count + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
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
	
}