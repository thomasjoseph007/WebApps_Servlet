package com.face.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.face.bo.ProductBO;

public class ProductDAO {

	
	public static boolean save(Connection connection, ProductBO pbo) throws SQLException {
		Statement s = connection.createStatement();
		String p = pbo.getPname();
		String pq= pbo.getPquantity();
		String pr = pbo.getPrice();
		String q = "INSERT INTO product( pname, pquantity, price) VALUES ('"+p+"','"+pq+"','"+pr+"')";
		int r = s.executeUpdate(q);
		System.out.println(r);
		if(r==1)		
			return true;
		else 
			return false;
		
	}

	public static ArrayList<ProductBO> list(Connection connection) throws SQLException {
		Statement s = connection.createStatement();
		String q = "select * from product";
		  ArrayList<ProductBO> list=new ArrayList<ProductBO>();        
          ProductBO p[] = new ProductBO[100];
          int i=0;
		ResultSet r = s.executeQuery(q);
		while(r.next())
		{
			System.out.println(r.getString("pname"));
			  p[i] = new ProductBO();
			  p[i].setId(r.getInt("id"));
			  p[i].setPname(r.getString("pname"));
			  p[i].setPquantity(r.getString("pquantity"));
			  p[i].setPrice(r.getString("price"));
			/*dataList.add(r.getString("pname"));
			 dataList.add(r.getString());
			 dataList.add(r.getString());*/
			  list.add(p[i]);
			i++;
			System.out.println("Added Sucessfully");
			
		}
		return list;
		
		
	}

	

	public static ArrayList<ProductBO> getall(Connection connection) throws SQLException {
		
		Statement s = connection.createStatement();
		String q = "select * from product";
		  ArrayList<ProductBO> list=new ArrayList<ProductBO>();        
          ProductBO p[] = new ProductBO[100];
          int i=0;
		ResultSet r = s.executeQuery(q);
		while(r.next())
		{
			System.out.println(r.getString("pname"));
			  p[i] = new ProductBO();
			  p[i].setId(r.getInt("id"));
			  p[i].setPname(r.getString("pname"));
			  p[i].setPquantity(r.getString("pquantity"));
			  p[i].setPrice(r.getString("price"));
			  list.add(p[i]);
			i++;
			System.out.println("Added Sucessfully");
			
		}
		return list;
	}

	public static ProductBO editproduct(Connection connection, int id) throws SQLException {
		Statement s = connection.createStatement();
		System.out.println("edit modal");
		String q = "select * from product where id="+id+"";
		System.out.println(q);
		ProductBO p= new ProductBO();
		ResultSet r = s.executeQuery(q);
		while(r.next()) {
			p.setId(r.getInt("id"));
			p.setPname(r.getString("pname"));
			p.setPquantity(r.getString("pquantity"));
			p.setPrice(r.getString("price"));
			System.out.println(r.getString("pname"));
			System.out.println(r.getString("pquantity"));
			System.out.println(r.getString("price"));
		}
		return p;
	}

}
