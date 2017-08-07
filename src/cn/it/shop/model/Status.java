package cn.it.shop.model;

/**
 * Status generated by hbm2java
 */
public class Status implements java.io.Serializable {

	private Integer id;
	private String status;

	public Status() {
	}
	
	public Status(int id) {
		this.id = id;
	}

	public Status(String status) {
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}