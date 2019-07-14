package ru.kalachteh.app.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;

public abstract class AbstractDaoControl<T, E extends Enum<E> > implements DaoControl<T,  E > {
	private final Logger log = Logger.getLogger(this.getClass());
		protected Connection connection;
		protected String keyField;
		protected  String SQL = "";
		protected StringBuilder sqlFilter;

		protected  HashMap<E , String> filter;
		protected ORDER order = ORDER.ASC;
		protected E orderField;
		
	public AbstractDaoControl(Connection connection) {
		// TODO Auto-generated constructor stub
		setConnection(connection);
	}
	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}
	
@Override
public List<T> getResult() {
// TODO Auto-generated method stub
	
return null;
}

@Override
public List<T> refresh() {
// TODO Auto-generated method stub
return null;
}

@Override
public T getById(int keyField) {
// TODO Auto-generated method stub
return null;
}

	@Override
	public void orderBy(E field, ORDER order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filterBy(ArrayList<String> filters, boolean add) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Map<String, String[]> listParams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Map<String, String[]> listParams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String[] listParams) {
		// TODO Auto-generated method stub
		
	}

	
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	protected boolean isConnection() {
		if (connection == null) return false;
		 
		try {
			return connection.isValid(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void setFilter(E field, String value) {
		
		filter.put( field, value);
		
	}
	public String getSqlFilter() {
		
		StringBuilder sql = new StringBuilder();
		if (!filter.isEmpty()) {
			
			String and="";
			for(Entry<E, String> entry : filter.entrySet()) {
				if(!StringUtils.isBlank(entry.getValue())) {
			sql.append(and+" "+entry.getKey().name()+" "+entry.getValue());
			and=" and ";}
				}
			if (sql.length()>0) {
				sql.insert(0, " where ");
			}
		}
		
		return sql.toString();
	}
	public void clearFilter() {
		
//		filter.replaceAll(null);
//		log.debug("clearFilter");
		
		for(Map.Entry<E, String> entry : filter.entrySet()) {
			entry.setValue(null);

		}
//		
//		filter.put(FIELD.Link_oborud_id, null);
//		filter.put(FIELD.date_begin, null);
//		filter.put(FIELD.gruppa_id, null);
//		filter.put(FIELD.invnumber, null);
//		filter.put(FIELD.material_id, null);
//		filter.put(FIELD.name, null);
//		filter.put(FIELD.note, null);
//		filter.put(FIELD.oborud_id, null);
//		filter.put(FIELD.sernumber, null);
//		filter.put(FIELD.spisan_flag, null);
//		filter.put(FIELD.summa, null);
	}
	public void clearFilterNotKey(Class<E> cl) {
		String keyValue = filter.get(Enum.valueOf(cl, getKeyField())) ;
		filter.replaceAll(null);
		filter.put(Enum.valueOf(cl, getKeyField()), keyValue);
	}
	
	
	
}
