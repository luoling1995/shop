package cn.it.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 容器的关闭并不会导致session销毁
 */
public class Forder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String phone;
	private String remark;
	private Date date;
	private double total;
	private String post;
	private String address;
	private User user;
	private Status status;
	private List<Sorder> sorderList = new ArrayList<Sorder>();
	
	public Forder(List<Sorder> sorderList) {
		super();
		this.sorderList = sorderList;
	}

	public List<Sorder> getSorderList() {
		return sorderList;
	}

	public void setSorderList(List<Sorder> sorderList) {
		this.sorderList = sorderList;
	}

	public Forder() {
	}

	public Forder(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

}
