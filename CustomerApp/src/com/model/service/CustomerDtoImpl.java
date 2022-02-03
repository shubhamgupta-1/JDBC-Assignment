package com.model.service;

import com.model.persistance.*;

public class CustomerDtoImpl implements CustomerDto{
	CustomerDao cs=new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer c) {
		cs.addCustomer(c); 
	}

	@Override
	public Customer getById(int id) {
		return cs.getById(id);
	}

}
