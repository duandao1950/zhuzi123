package com.struts.report;

public class Customer {
	private String name = null;

	private Integer sales = null;

	public Customer(String name, Integer sales) {
		this.name = name;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
