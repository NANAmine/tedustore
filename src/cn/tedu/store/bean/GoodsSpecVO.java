package cn.tedu.store.bean;

public class GoodsSpecVO {

	Integer id;
	String spec;

	public GoodsSpecVO() {
		super();
	}

	public GoodsSpecVO(Integer id, String spec) {
		super();
		this.id = id;
		this.spec = spec;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "GoodsSpecVO [id=" + id + ", spec=" + spec + "]";
	}
	
	
}