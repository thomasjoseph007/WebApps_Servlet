package com.face.dao;

import java.sql.Connection;

import com.face.util.MySQLConnection;

public class ConnectionUtils {
	public static Connection getConnection()
            throws Exception {
       return MySQLConnection.getConnection();
  }

	public static void rollbackQuietly(Connection conn) {
	       try {
	           conn.rollback();
	       } catch (Exception e) {
	       }
	   }

	public static void closeQuietly(Connection conn) {
       try {
           conn.close();
       } catch (Exception e) {
       }
   }
}
