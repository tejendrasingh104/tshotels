package com.tshotels.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcUtility {

	static
	{
		//load and register the driver
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Driver registered...");
	}
	// Establish the connection
	public static Connection dbconnect() throws SQLException
	{
			String url="jdbc:mysql://localhost:3306/teluskodb";
			String username="root";
			String password="root";
			return DriverManager.getConnection(url, username, password);
	}
	
	// close resources
	public static void closeResources(Statement pstmt,Connection connect) throws SQLException
	{
		if(pstmt !=null)
		{
			pstmt.close();
		}
		if(connect !=null)
		{
			connect.close();
		}
	}

}
