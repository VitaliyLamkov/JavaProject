package ru.kalachteh.app.dao;

import java.sql.*;


public class MainConnection extends AbstractDaoConnection{
	
	private Connection connection;

	public MainConnection(String path, String name, String password) {
		super(path, name, password);
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		
		try {
			 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) {
 
        e.printStackTrace();
        }
		
		try
		{
			
			
			return DriverManager.getConnection(PATH, NAME , PASSWORD);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
//		return super.getConnection();
	}
	
	public ResultSet getSt() {
		Statement statement;
		ResultSet ResultSet ;
		try {
			statement = connection.createStatement();
			ResultSet = statement.executeQuery("Select * from Personnel");
			return ResultSet ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}
