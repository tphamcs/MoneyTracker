package com.revature.moneytracker.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.moneytracker.dao.ProductDao;
import com.revature.moneytracker.model.Product;


/**
 * Servlet implementation class ServletController
 * Handling request from user
 */

@WebServlet("/")
public class ServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductDao productCrud;

    /**
     * Default constructor. 
     */
    public ServletController() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        productCrud = new ProductDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		 
        try {
          switch (action) {
            case "/home":
                showNewForm(request, response);
                break;
            case "/login":
                showNewForm(request, response);
                break;
            case "/admin":
                showNewForm(request, response);
                break;
            case "/insert":
                insertProduct(request, response);
                break;
            case "/delete":
                deleteProduct(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        
        Product newProduct = new Product(title, category, date, amount);
        productCrud.insertUser(newProduct);
        
        response.sendRedirect("list");
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
