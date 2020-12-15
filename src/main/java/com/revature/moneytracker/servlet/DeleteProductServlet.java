package com.revature.moneytracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.moneytracker.MoneyTracker;
import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;
import com.revature.moneytracker.service.ProductService;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private ProductService productService = new ProductService();
	
	final static Logger logger = Logger.getLogger(DeleteProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("DeleteProductServlet's doGet() called");
		
		//Retriving current user from session
		//HttpSession session=request.getSession(false);
		//User user = (User) session.getAttribute("user"); 

		
		//getting product id we want to delete from url
        int pid = Integer.parseInt(request.getParameter("id"));
        
		try {
			
			//callubg delete product from service layer
			productService.deleteProduct(pid);
			
			
		} catch (Exception e) {
			response.setStatus(400);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
