package cn.it.shop.model;

public class Category implements java.io.Serializable {
	private Integer id;
	private String type;
	private Boolean hot;
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Category(Integer id, String type, Boolean hot) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	public Category(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + ", hot=" + hot + "]";
	}
	
	

}
