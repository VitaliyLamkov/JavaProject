package ru.kalachteh.app.dao;
import java.sql.Connection;
import java.sql.SQLException;
public interface DaoConnection {
	public Connection getConnection() throws SQLException ;
	
}
