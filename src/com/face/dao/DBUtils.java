package com.face.dao;

import java.sql.*;


import com.face.bo.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
		       String sql = "Select a.User_Name, a.Password from User_Account a " //
		               + " where a.User_Name = ? and a.password= ?";
		       PreparedStatement pstm = conn.prepareStatement(sql);
		       pstm.setString(1, userName);
		       pstm.setString(2, password);
		       ResultSet rs = pstm.executeQuery();
		       System.out.println(rs);
		       if (rs.next()) {
		           
		           UserAccount user = new UserAccount();
		           user.setUserName(userName);
		           user.setPassword(password);
		           
		           
		           return user;
		       }
		return null;
	}

}
