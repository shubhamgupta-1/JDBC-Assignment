package com.ymsli.mvc.model.service;

import java.util.List;
import java.util.Optional;

import com.ymsli.mvc.model.exceptions.DataAccessException;
import com.ymsli.mvc.model.persistance.product.Product;
import com.ymsli.mvc.model.persistance.product.ProductDao;
import com.ymsli.mvc.model.persistance.product.ProductDaoImpl;

public class ProductServiecImpl implements ProductService{
	private ProductDao productDao;
	public ProductServiecImpl(){
		productDao=new ProductDaoImpl();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		productDao.updateProduct(id, product);
		
	}

	@Override
	public List<Product> getAllProduct() throws DataAccessException {
		return productDao.getAllProduct();
	}

	@Override
	public Optional<Product> getById(int id) {
		return productDao.getById(id);
	}

}
