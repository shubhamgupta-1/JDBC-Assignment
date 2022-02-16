package com.ymsli.mvc.model.persistance.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ymsli.mvc.model.exceptions.DataAccessException;
import com.ymsli.mvc.model.persistance.factory.ConnectionFactory;

public class ProductDaoImpl implements ProductDao {
	private Connection connection;
	public ProductDaoImpl(){
		connection=ConnectionFactory.getConnection();
		
	}
	@Override
	public Product addProduct(Product product) {
		try {
			PreparedStatement pstmt=connection.prepareStatement("insert into product (name,price,qty,mfd,Inspection_date) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,product.getName());
			pstmt.setDouble(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.setDate(4, product.getMfd());
			pstmt.setDate(5, product.getInspDate());
			pstmt.executeUpdate();
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()) {
				product.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public void deleteProduct(int id) {
		
		try {
			PreparedStatement pstmt=connection.prepareStatement("delete from product where id =?" );
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateProduct(int id, Product product) {
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("update product set price =?,qty=?,mfd=?,inspection_date=? where id=? ");
			pstmt.setDouble(1, product.getPrice());
			pstmt.setInt(2, product.getQty());
			pstmt.setDate(3, product.getMfd());
			pstmt.setDate(4, product.getInspDate());
			pstmt.setInt(5,product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public List<Product> getAllProduct() throws DataAccessException {
		List <Product> products=new ArrayList<>();
		Product tempProduct;
		try {
		PreparedStatement pstmt=connection.prepareStatement("select * from product");
		pstmt.executeQuery();
		ResultSet rs=pstmt.getResultSet();
		while(rs.next()) {
			tempProduct=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(6),rs.getDate(4),rs.getDate(5));
			products.add(tempProduct);
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return products;
	}
	@Override
	public Optional<Product> getById(int id) {
		Product product=null;
			try {
				PreparedStatement pstmt=connection.prepareStatement("select * from product where product id=?");
				pstmt.setInt(1,id);
				pstmt.executeQuery();
				ResultSet rs=pstmt.getResultSet();
				if(rs.next()) {
					product=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(6),rs.getDate(4),rs.getDate(5));
					}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(product);
	}

}
