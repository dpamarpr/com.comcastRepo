 package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
Connection conn;
	
	public void getDBConnection(String url , String username , String password) throws SQLException {
		try {
		Driver dri= new Driver();
		DriverManager.registerDriver(dri);
	    conn=DriverManager.getConnection(url ,username ,password);
		}
		catch(Exception e){
		}	
	}
		
		public void getDBConnection() throws SQLException {
			try {
			Driver dri= new Driver();
			DriverManager.registerDriver(dri);
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects" ,"root" ,"root");
			}
			catch(Exception e){
				
			}
	}
	
	public void closeDBConnection() throws SQLException {
		try {
		conn.close();
		}catch(Exception e){
			
		}
	}
	
	public ResultSet excuteSelectQuery(String query) throws SQLException {
		
		ResultSet result=null;
		try {
		Statement stat= conn.createStatement();
		 result= stat.executeQuery(query);
		}catch(Exception e){
			
		}
		return result;
	}
	 	
	public int executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try {
		Statement stat= conn.createStatement();
		 result= stat.executeUpdate(query);
		}catch(Exception e) {
			
		}
		return result;
	}	
	

}
