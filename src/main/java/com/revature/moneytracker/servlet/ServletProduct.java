package com.revature.moneytracker.servlet;

import java.io.IOException;

import javax.management.relation.RoleNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.service.ProductService;

/**
 * Servlet implementation class ServletProduct
 */
public class ServletProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Current user
		int authorID = Integer.parseInt(request.getParameter("authorID"));
		
		//Product fields
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        double amount = Double.parseDouble(request.getParameter("amount"));
        
		try {
			
			Product product = productService.insertProduct(authorID, title, category, date, amount);
			
		} catch (Exception e) {
			response.setStatus(400);
		}
	}

}
