package ru.kalachteh.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Array;
import java.sql.PreparedStatement;

public class Query extends AbstractDaoQuery {
	boolean fQuery = false;
	
	public ArrayList<Row> tableArray = new ArrayList<Row>();

	public Query() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setConnection(MainConnection connection) {
		// TODO Auto-generated method stub
		super.setConnection(connection);
	}

	@Override
	public void setTable(String table) {
		// TODO Auto-generated method stub
		super.setTable(table);
	}

	@Override
	public void setPk(String pk) {
		// TODO Auto-generated method stub
		super.setPk(pk);
	}

	@Override
	public void setFields(ArrayList<String> fields) {
		// TODO Auto-generated method stub
		super.setFields(fields);
	}

	@Override
	public void setWhere(HashMap<String, String> where) {
		// TODO Auto-generated method stub
		super.setWhere(where);
	}

	@Override
	public void setOrderBy(HashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		super.setOrderBy(orderBy);
	}

	@Override
	public void getAll() throws SQLException {
		
		// TODO Auto-generated method stub
//		try (PreparedStatement statement = connection.getConnection().prepareStatement(getSql())){
		try {
			//PreparedStatement statement = connection.getConnection().createStatement();
			System.out.println("**************************************");
			System.out.println(getSql());
			Statement statement = connection.getConnection().createStatement();
			this.resultSet = statement.executeQuery(getSql());
			
//			while (result.next()) {
//				String surname = result.getString("Surname");
//				String name = result.getString("Name");
//				String patronymic = result.getString("Patronymic");
//				System.out.println(surname +" | "+name + " | "+ patronymic);
//				
//			}
			
			//ResultSet rs = statement.executeQuery();
		
		System.out.println("Resulset ");
//			
		
		while (resultSet.next()) {
				Row row = new Row();
				for (String field :   fields) {
//					System.out.println("field =" + field);
//					System.out.println("value = " + result.getString(field));
//					
					
					row.setField(field, resultSet.getString(field));
					//row.setField("sdfsd00", "sdfss");
//					System.out.println("@@@@" + row.toString());
				}
			//	System.out.println("@@@@@@@@@@@@"+result.getArray(2));
				tableArray.add(row);
			}
			
			
//		System.out.println("!!!!!!!!!!!!!!!RS");
//			System.out.println("RS" + tableArray.toString());
			
			resultSet.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new SQLException();
		}
	}

	@Override
	public void insert(HashMap<String, String> insert) {
		// TODO Auto-generated method stub
		super.insert(insert);
	}

	@Override
	public void update(HashMap<String, String> update) {
		// TODO Auto-generated method stub
		super.update(update);
	}

	@Override
	public void delete(int pk) {
		// TODO Auto-generated method stub
		super.delete(pk);
	}

	@Override
	public void getById(int pk) {
		// TODO Auto-generated method stub
		super.getById(pk);
	}

	@Override
	public void orderBy() {
		// TODO Auto-generated method stub
		super.orderBy();
	}

	@Override
	public void whereBy() {
		// TODO Auto-generated method stub
		super.whereBy();
	}
	
	@Override
	public String getSql() {
		
		if (isSql()) {
			System.out.println("begin sql");
		StringBuilder str = new StringBuilder();
		str.append("SELECT");
		int first = 0;
			for (String field : fields) {
				if (first == 0) {
				str.append(" " + field);
				first =1;
				}
				else str.append(", " + field);
			}
			
		str.append(" FROM " + table);
		
//		if (!where.isEmpty()) {
//			str.append(" WHERE ");
//			for (Map.Entry<String, String> condition : where.entrySet() ) {
//				str.append(condition.getKey() + condition.getValue());
//			}
//		
//		}
//		if (!orderBy.isEmpty()) {	
//		str.append("ORDERBY ");
//			for (Map.Entry<String, String> field: orderBy.entrySet()) {
//				str.append(field.getKey() + " " + field.getValue());
//			}
//		
//		
//		}
		System.out.println("end sql");
		return str.toString();
		}
		
		return null;
	
	}
	
	private boolean isSql() {
		
		if (table.isEmpty())
			return false;
		if (pk.isEmpty())
			return false;
		if (fields.isEmpty())
			return false;
		
//		System.out.println(table);
//		System.out.println(pk);
//		System.out.println(fields);
//		
		return true;
	}
}
