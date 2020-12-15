package com.revature.moneytracker.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;
import com.revature.moneytracker.service.ProductService;

/**
 * Servlet implementation class ListProductServlet
 */
public class ListProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
	
	final static Logger logger = Logger.getLogger(ListProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("ListProductServlet's doGet() called");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {

			//Retriving current user from session
			//HttpSession session=request.getSession(false);
			//User user = (User) session.getAttribute("user");
			
			//get all Product of current user
			ArrayList<Product> listProduct = productService.getAllProduct(uid);
			
			//send listProduct object to jsp page
			//request.setAttribute("listProduct", listProduct);
			//request.getRequestDispatcher("dashboard.jsp").forward(request, response); 
			
			
			//set the response content type to JSON
			//convert response object to json	    			
			String listProductJSON = objectMapper.writeValueAsString(listProduct);
			
			response.getWriter().append(listProductJSON);
			//set the response content type to JSON
			response.setContentType("application/json");
			response.setStatus(201);

			
		} catch (Exception e) {
			response.setStatus(400);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
