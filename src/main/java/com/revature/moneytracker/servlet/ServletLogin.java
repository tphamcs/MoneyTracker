package com.revature.moneytracker.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.revature.moneytracker.dao.UserDao;
import com.revature.moneytracker.model.User;

/**
 * Servlet implementation class LoginServlet
 */

public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(ServletLogin.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("ServletLogin's doPost() called");
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        UserDao userDao = new UserDao();
         
        try {
        	//check user credential from userDao.java
            User user = userDao.checkLogin(username, password);
             
            //if user found
            if (user != null) {
            	//validating user based on their role
            	if (user.getRole().equals("regular_user")){
            		
            		//creating session to store User object, this can be used as Global user
            		HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    
                    //should redirect to listProduct servlet first
                    //since this function will grab all the current user database
            		response.sendRedirect("dashboard.jsp");
            		
            	} else if (user.getRole().equals("admin")) {
            		
            		response.sendRedirect("adminhome.jsp");
				}
            	         	
            } else {       	
            	response.sendRedirect("error.jsp");
            	return;
            }
             
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
