/**
 * 
 */
package com.sai.jsp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * @author sv
 *
 */
public class LoginDao {

	String sql = "select * from login where username =? and password =?";
	String url = "jdbc:mysql://localhost:3306/sai";
	String dbusername = "root";
	String dbpassword = "mysqladmin";

	public boolean checkUserExist(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbusername, dbpassword);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
