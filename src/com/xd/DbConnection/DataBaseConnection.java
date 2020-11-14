package com.xd.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/coffeeDb","root","");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				System.out.println(e);
			}
			return conn;
		}
	}
}
