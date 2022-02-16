package com.ymsli.mvc.model.service;

import java.util.List;
import java.util.Optional;
import com.ymsli.mvc.model.exceptions.DataAccessException;
import com.ymsli.mvc.model.persistance.product.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public void deleteProduct(int id);
	public void updateProduct(int id,Product product);
	public List<Product> getAllProduct() throws DataAccessException;
	public Optional<Product> getById(int id);
	
}
