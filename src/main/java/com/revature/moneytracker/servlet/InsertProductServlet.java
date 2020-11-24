package com.revature.moneytracker.servlet;

import java.io.IOException;
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
 * Servlet implementation class InsertProductServlet
 */
public class InsertProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
	
	final static Logger logger = Logger.getLogger(InsertProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("InsertProductServlet's doPost() called");
		
		//Retriving current user from session
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("user"); 

		
		//Product fields value from dashboard.jsp
		int authorID = user.getId();
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        int amount = Integer.parseInt(request.getParameter("amount"));
        
		try {
			
			//insert product to database
			Product product = productService.insertProduct(authorID, title, category, date, amount);
			
			//set the response content type to JSON
			response.setContentType("application/json");
			response.setStatus(201);
			//redirect back to dashboard
			response.sendRedirect("createList.jsp");
			
		} catch (Exception e) {
			response.setStatus(400);
		}
	}

}
