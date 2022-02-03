package com.model.service;

import com.model.persistance.Customer;

public interface CustomerDto {
	void addCustomer(Customer c);
	Customer getById(int id);
}
