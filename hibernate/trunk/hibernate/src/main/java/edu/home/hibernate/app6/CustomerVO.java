package edu.home.hibernate.app6;

public class CustomerVO {

	private Long customerPk; // Reference type
	private String customerName;
	private String customerAddress;

	public CustomerVO(Long customerPk, String customerName, String customerAddress) {
		this.customerPk = customerPk;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public Long getCustomerPk() {
		return customerPk;
	}

	public void setCustomerPk(Long customerPk) {
		this.customerPk = customerPk;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
