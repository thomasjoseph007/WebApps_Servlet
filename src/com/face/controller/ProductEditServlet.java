package com.face.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class ProductEditServlet
 */
@WebServlet(urlPatterns = { "/ProductEdit" })

public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to Product Edit Servlet");
	      
		response.setContentType("text/html");
		ConnectionManger con = new ConnectionManger();
		ProductBO bpo = new ProductBO();
		int id = Integer.parseInt(request.getParameter("id"));
	
		
		try {
			bpo=ProductDAO.editproduct(con.getConnection(),id);
			request.setAttribute("datas", bpo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductAddView.jsp?#myModal");
		 if (dispatcher != null){
			  dispatcher.forward(request, response);
			  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		ConnectionManger con = new ConnectionManger();
		ProductBO bpo = new ProductBO();
		
		ArrayList<ProductBO> product;
		
		try {
			
			product = ProductDAO.getall(con.getConnection());
			request.setAttribute("data", product);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		
		boolean p = false;
		
		
		
			try {
				bpo=ProductDAO.editproduct(con.getConnection(),id);
				request.setAttribute("datas", bpo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductAddView.jsp");
			 if (dispatcher != null){
				  dispatcher.forward(request, response);
				  }
	}

}
