package ru.kalachteh.app.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import ru.kalachteh.app.dao.MainConnection;

public interface DaoQuery {
	
	public void setConnection(MainConnection connection);
	public void setTable(String table);
	public void setPk(String pk);
	public void setFields(ArrayList<String> fields);
	public void setWhere(HashMap<String, String> where);
	public void setOrderBy(HashMap<String, String> orderBy);
	public void getAll() throws SQLException;
	public void insert(HashMap<String, String> insert);
	public void update(HashMap<String, String> update);
	public void delete(int pk);
	public void getById(int pk);
	public void orderBy();
	public void whereBy();
	
	
	
}
