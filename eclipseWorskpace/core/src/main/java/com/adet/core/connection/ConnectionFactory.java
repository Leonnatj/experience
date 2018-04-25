package com.adet.core.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static final int TYPE_MYSQL = 0;
	public static final int TYPE_DB2 = 1;

	public static Connection getConnection(int db) {
		Connection con = null;
		try {
			switch (db) {
			case TYPE_MYSQL: {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");
				break;
			}
			case TYPE_DB2: {
//				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");
			}
			default: {
				con = null;
			}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
