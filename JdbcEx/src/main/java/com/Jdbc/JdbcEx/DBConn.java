package com.Jdbc.JdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("JDBC Connection Success");
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Connection Closed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
