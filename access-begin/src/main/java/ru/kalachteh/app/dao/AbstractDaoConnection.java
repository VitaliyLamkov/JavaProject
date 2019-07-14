package ru.kalachteh.app.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDaoConnection  implements DaoConnection{
	final String PATH;
	final String NAME;
	final String PASSWORD;
	
	public AbstractDaoConnection(String path, String name, String password){
		this.PATH = path;
		this.NAME = name;
		this.PASSWORD = password;
		
	}
	
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
