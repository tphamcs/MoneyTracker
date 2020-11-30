package com.revature.moneytracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.moneytracker.dao.UserDao;
import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;
import com.revature.moneytracker.service.ProductService;
import com.revature.moneytracker.service.UserService;

/**
 * Servlet implementation class ServletSignUp
 */
public class ServletSignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	
	final static Logger logger = Logger.getLogger(ServletSignUp.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.info("ServletSignUp's doPost() called");
		
	
		//Product fields value from dashboard.jsp
		String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //set default role to 'authenticated' here since admin user not going to use this signup
        String role = "authenticated";
        

        
		try {
			
			//check if this user is already exist
			UserDao userDao = new UserDao();
            User user = userDao.checkLogin(username, password);
             
            //if user found
            if (user != null) {
            	        	
            	
            	response.sendRedirect("signup.jsp");
            	
            	System.out.println("This account already exist");
     	
            } else {
            	
    			//insert new user to database
    			userService.insertUser(fullname, role, email, username, password);
    			
                  
                //set the response content type to JSON
    			response.setContentType("application/json");              
                response.setStatus(201);
                //redirect back to dashboard
    			response.sendRedirect("login.jsp");
    			
    			System.out.println("Signup succesfully. Please login");
            }

	
			
		} catch (Exception e) {
			response.setStatus(400);
		}
		
	}

}
