package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

private static Connection conn = null;
	
	public static Connection getConnection() { // Encapsulation of the logic to connect 
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

		try {
			Properties props = new Properties();
			
			//The following lines just ensure we find connection.properties regardless of how our project is built:
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("connection.properties")); //changed to db as per file is correct 0738
			
			// All we've done is set these value to the values found in connection.properties
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			// How to actually make connection with jdbc
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("--online--");
									
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
//class closed	
}