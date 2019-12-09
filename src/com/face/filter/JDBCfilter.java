package com.face.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.dao.ConnectionUtils;
import com.face.dao.MyUtils;


/**
 * Servlet implementation class JDBCfilter
 */
@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCfilter implements Filter {
	
	public JDBCfilter() {
	   }
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
	   private boolean needJDBC(HttpServletRequest request) {
	       System.out.println("Step 1:Welcome to Filter");
	       //
	       // Servlet Url-pattern: /spath/*
	       //
	       // => /spath
	       String servletPath = request.getServletPath();
	       System.out.println("Servlet Path"+servletPath);
	       // => /abc/mnp
	       String pathInfo = request.getPathInfo();
	       System.out.println("PathInfo"+pathInfo);
	       String urlPattern = servletPath;
	       System.out.println("URL"+urlPattern);
	       if (pathInfo != null) {
	           // => /spath/*
	           urlPattern = servletPath + "/*";
	       }
	        // Key: servletName.
	       // Value: ServletRegistration
	       Map<String, ? extends ServletRegistration> servletRegistrations =
	               request.getServletContext()
	               .getServletRegistrations();
	       // Collection of all servlet in your Webapp.
	       Collection<? extends ServletRegistration> values =
	               servletRegistrations.values();
	       for (ServletRegistration sr : values) {
	           Collection<String> mappings = sr.getMappings();
	           if (mappings.contains(urlPattern)) {
	               return true;
	           }
	       }
	       return false;
	   }
	   @Override
	   public void doFilter(ServletRequest request, ServletResponse response,
	           FilterChain chain)
	           throws IOException, ServletException {
	       HttpServletRequest req = (HttpServletRequest) request;
	       // Only open connections for the special requests.
	       // (For example, the path to the servlet, JSP, ..)
	       //
	       // Avoid open connection for commons request.
	       // (For example: image, css, javascript,... )
	       //
	       if (this.needJDBC(req)) {
	           System.out.println("Open Connection for: " + req.getServletPath());
	           Connection conn = null;
	           try {
	               // Create a Connection.
	               conn = ConnectionUtils.getConnection();
	               // Set auto commit to false.
	               conn.setAutoCommit(false);
	               // Store Connection object in attribute of request.
	               MyUtils.storeConnection(request, conn);
	               // Allow request to go forward
	               // (Go to the next filter or target)
	               chain.doFilter(request, response);
	               // Invoke the commit() method to complete the transaction with the DB.
	               conn.commit();
	           } catch (Exception e) {
	               e.printStackTrace();
	               ConnectionUtils.rollbackQuietly(conn);
	               throw new ServletException();
	           } finally {
	               ConnectionUtils.closeQuietly(conn);
	           }
	       }
			else
				chain.doFilter(request, response);	
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
		doGet(request, response);
	}

	
	
	
	

}
