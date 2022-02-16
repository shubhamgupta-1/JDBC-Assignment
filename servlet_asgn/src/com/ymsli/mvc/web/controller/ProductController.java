package com.ymsli.mvc.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymsli.mvc.model.exceptions.ProductNotFoundException;
import com.ymsli.mvc.model.persistance.product.Product;
import com.ymsli.mvc.model.service.ProductService;
import com.ymsli.mvc.model.service.ProductServiecImpl;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService=new ProductServiecImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("showall")) {
			List<Product> products=productService.getAllProduct();
			request.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("AllProduct.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("addproduct")) {
			RequestDispatcher rd=request.getRequestDispatcher("AddProduct.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("delete")) {
			Integer id= Integer.parseInt(request.getParameter("id").trim());
			productService.deleteProduct(id);
			response.sendRedirect("productController?action=showall");
		}
		else if(action.equalsIgnoreCase("update")) {
			Integer id= Integer.parseInt(request.getParameter("id").trim());
			
			Product product=productService.getById(id)
					.orElseThrow(()-> new ProductNotFoundException("emp with id"+ id+" is not found") );
			
			request.setAttribute("Product",product);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id").trim());
		String name=request.getParameter("pName");
		Double price=Double.parseDouble(request.getParameter("pPrice"));
		int qty=Integer.parseInt(request.getParameter("pQuantity"));
		Date mfd=Date.valueOf(request.getParameter("mfdDate"));
		Date inspection=Date.valueOf(request.getParameter("insDate"));
		Product product=new Product(name,price,qty,mfd,inspection);
		if(id==0) {
			productService.addProduct(product);
		}
		else {
			productService.updateProduct(id, product);
		}
		response.sendRedirect("productController?action=showall");
	}

}
