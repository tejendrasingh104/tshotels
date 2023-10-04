package com.tshotels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private String name;
	private String email;
	private String phone;
	private String address;
	private int rowsAffected;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int insert() 
	{
		try 
		{
			connect	= JdbcUtility.dbconnect();
			String query="INSERT INTO guest(Name,Email,Phone,Address) VALUES(?,?,?,?)";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			
			rowsAffected = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				JdbcUtility.closeResources(pstmt,connect);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected;
	}
}
