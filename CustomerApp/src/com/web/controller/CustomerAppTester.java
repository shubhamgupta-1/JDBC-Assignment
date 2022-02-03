package com.web.controller;

import com.model.service.*;
import com.model.persistance.*;

import java.sql.*;

public class CustomerAppTester {

	public static void main(String[] args) {
		CustomerDto customerService=new CustomerDtoImpl(); 
		
		
		System.out.println("add new customer");
		customerService.addCustomer(new Customer(111, "gagan", "yamaha","8928972", Date.valueOf("1999-02-05")));
		customerService.addCustomer(new Customer(125, "anmol", "yamaha","1526728819", Date.valueOf("1996-05-20")));
		
		
		Customer customer=customerService.getById(1);
		System.out.println("get by id");
		System.out.println(customer);


	}

}