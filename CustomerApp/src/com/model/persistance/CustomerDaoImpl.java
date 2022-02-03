package com.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDaoImpl implements CustomerDao{
	Connection connection=null;
	@Override
	public void addCustomer(Customer c) {
		PreparedStatement stmt;
		try {
			stmt = connection
					.prepareStatement("insert into Customer(name,address,phoneNumber,dob) values (?,?,?,?)");
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getAddress());
			stmt.setString(3, c.getPhoneNumber());
			stmt.setDate(4, c.getDob());
			int noOfRowsAffected = stmt.executeUpdate();
			System.out.println("No. of rows affected : " + noOfRowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer getById(int id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("Select * from book where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Customer(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			} else {
				throw new CustomerNotFoundException("Customer with id =" + id + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
