package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static final String URL = "jdbc:mysql://localhost:3306/moviex_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "F0otballl0ve!";
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		catch (Exception e) {
           e.printStackTrace();
        }

        return conn;
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnect.getConnection();
		System.out.println(connection);
		}
	
	
     
	/*private static Connection conn;
    

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviex_db", "root", "F0otballl0ve!");
			

        }
		catch(ClassNotFoundException c){
			System.out.println("sfdsaf");
		}
		catch (Exception e) {
			System.out.println("hi");
           e.printStackTrace();
        }

        return conn;
	}*/

	
}
