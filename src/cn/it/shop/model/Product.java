package cn.it.shop.model;

import java.sql.Timestamp;

public class Product implements java.io.Serializable {
	private Integer id;
	private String name;
	private Double price;
	private String pic;
	private String remark;
	private String xremark;
	private Timestamp date;
	private Boolean commend;
	private Boolean open;
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getXremark() {
		return xremark;
	}

	public void setXremark(String xremark) {
		this.xremark = xremark;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Boolean getCommend() {
		return commend;
	}

	public void setCommend(Boolean commend) {
		this.commend = commend;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + "]";
	}

}
