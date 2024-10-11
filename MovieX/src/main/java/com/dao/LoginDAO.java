package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBConnect;

public class LoginDAO {
	private String dbUrl = "jdbc:mysql://localhost:3306/moviex_db";
    private String dbUname = "root";
    private String dbPassword = "F0otballl0ve!";
    
    private String dbDriver = "com.mysql.jdbc.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
	
    
    public boolean validate(LoginObj loginBean)  {
        
       // loadDriver(dbDriver);
    	boolean status = false;
    	try {
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM tbl_users WHERE username = ? and password = ?";

        PreparedStatement ps;
        
            ps = con.prepareStatement(sql);
            ps.setString(1, loginBean.getUsername());
            ps.setString(2, loginBean.getPassword());
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

}
