package com.struts.report;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class ListAllCustomersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(ListAllCustomersAction.class);
	private List<Customer> customers;

	@Override
	public String execute() throws Exception {
		customers = CustomerService.listAllCustomers();
		LOG.info("get all customers and return success.");
		return SUCCESS;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
}
