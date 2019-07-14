package ru.kalachteh.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public abstract class AbstractDaoQuery implements DaoQuery{
	protected MainConnection connection;
	protected String table;
	protected String pk;
	protected ArrayList<String> fields;
	protected HashMap<String, String> orderBy;
	protected HashMap<String, String> where;
	protected HashMap<String, String> update;
	protected HashMap<String, String> delete;
	protected HashMap<String, String> insert;
	protected String sql;
	protected ResultSet resultSet;
	
	public AbstractDaoQuery() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setConnection(MainConnection connection) {
		// TODO Auto-generated method stub
		this.connection =connection;
	}

	@Override
	public void setTable(String table) {
		// TODO Auto-generated method stub
		this.table = table;
	}

	@Override
	public void setPk(String pk) {
		// TODO Auto-generated method stub
		this.pk = pk;
	}

	@Override
	public void setFields(ArrayList<String> fields) {
		// TODO Auto-generated method stub
		this.fields = fields;
	}

	@Override
	public void setWhere(HashMap<String, String> where) {
		// TODO Auto-generated method stub
		this.where = where;
	}

	@Override
	public void setOrderBy(HashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		this.orderBy = orderBy;
	}

	@Override
	public void getAll() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(HashMap<String, String> insert) {
		// TODO Auto-generated method stub
		this.insert = insert;
	}

	@Override
	public void update(HashMap<String, String> update) {
		// TODO Auto-generated method stub
		this.update = update;
	}

	@Override
	public void delete(int pk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getById(int pk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderBy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void whereBy() {
		// TODO Auto-generated method stub
		
	}
	public String getSql() {
		return null;
	}
	
}
