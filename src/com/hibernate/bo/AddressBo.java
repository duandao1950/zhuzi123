package com.hibernate.bo;

import com.hibernate.bo.ibo.IAddressBo;
import com.hibernate.dao.AddressDAO;

public class AddressBo extends BaseHibernateBo implements IAddressBo{
	private AddressDAO addressDAO;

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
}
