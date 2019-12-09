package com.face.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.util.ConnectionManger;
import com.face.bo.ProductBO;
import com.face.dao.ProductDAO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns = { "/Product" })

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to Login Servlet");
	       // Forward to /WEB-INF/views/loginView.jsp
	       // (Users can not access directly into JSP pages placed in WEB-INF)
		ConnectionManger con = new ConnectionManger();
		 ArrayList<ProductBO> list =new ArrayList<ProductBO>();
		 try {
			list=ProductDAO.list(con.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 request.setAttribute("data", list);
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductAddView.jsp");

		  if (dispatcher != null){
		  dispatcher.forward(request, response);
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String pname = request.getParameter("pname");
		String pquantity = request.getParameter("pquantity");
		String price = request.getParameter("price");
		
		ProductBO pbo = new ProductBO();
		
		pbo.setPname(pname);
		pbo.setPquantity(pquantity);
		pbo.setPrice(price);
		boolean p = false;
		ConnectionManger con = new ConnectionManger();
		try {
			p=ProductDAO.save(con.getConnection(),pbo);
			 if(p==true) {
				  ArrayList<ProductBO> list =new ArrayList<ProductBO>();
				 list=ProductDAO.list(con.getConnection());
				 
				 
				 request.setAttribute("data", list);
				 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductAddView.jsp");

				  if (dispatcher != null){
				  dispatcher.forward(request, response);
//				  response.sendRedirect(request.getContextPath() + "/home.jsp");

				  } 
	
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
