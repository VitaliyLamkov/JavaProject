package ru.kalachteh.app.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.sql.Connection;

public interface DaoControl<T, E extends Enum<E>> {
	public void setConnection(Connection connection);
	public List<T> getResult();
	public List<T> refresh();
	public T getById(int keyField);
	public void orderBy(E field, ORDER order);
	public void filterBy(ArrayList<String> filters, boolean add);
	public void insert(Map<String, String[]> listParams);
	public void update(Map<String, String[]> listParams);
	public void delete(String[] listParams);
	public void setFilter(E field, String value) ;
	public String getSqlFilter() ;
	public void clearFilter();
	public void clearFilterNotKey(Class<E> cl) ;
	
}
