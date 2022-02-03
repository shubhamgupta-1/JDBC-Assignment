package com.model.persistance;

public interface CustomerDao {
	void addCustomer(Customer c);
	Customer getById(int id);
}
