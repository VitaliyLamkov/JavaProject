package ru.kalachteh.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ControlEntityLink extends AbstractDaoControl <EntityLink, LINKFIELD >{
	private static final Logger log = Logger.getLogger(ControlEntityLink.class);
	private List<EntityLink> entityLink = new ArrayList<EntityLink>();
//	private final String SQL = "SELECT * FROM `LinkOborud` " + 
//			"	LEFT JOIN `material` ON `LinkOborud`.`oborud_id` = `material`.`material_id`";
//	private StringBuilder sqlFilter = new StringBuilder();
	private ArrayList<String> filters;
//	private HashMap<LINKFIELD, String> filter = new HashMap<ControlEntityLink.FIELnumD, String>(){{
//		put(LINKFIELD.Link_oborud_id, null);
//		put(LINKFIELD.date_begin, null);
//		put(LINKFIELD.gruppa_id, null);
//		put(LINKFIELD.invnumber, null);
//		put(LINKFIELD.material_id, null);
//		put(LINKFIELD.name, null);
//		put(LINKFIELD.note, null);
//		put(LINKFIELD.oborud_id, null);
//		put(LINKFIELD.sernumber, null);
//		put(LINKFIELD.spisan_flag, null);
//		put(LINKFIELD.summa, null);
//		
//	}};
	
	public ControlEntityLink(Connection connection) {
		super(connection);
		
		SQL = "SELECT * FROM `LinkOborud` " + 
				"	LEFT JOIN `material` ON `LinkOborud`.`oborud_id` = `material`.`material_id`";
		sqlFilter = new StringBuilder();
		
		filter = new HashMap<LINKFIELD, String>(){{
			put(LINKFIELD.Link_oborud_id, null);
			put(LINKFIELD.date_begin, null);
			put(LINKFIELD.gruppa_id, null);
			put(LINKFIELD.invnumber, null);
			put(LINKFIELD.material_id, null);
			put(LINKFIELD.name, null);
			put(LINKFIELD.note, null);
			put(LINKFIELD.oborud_id, null);
			put(LINKFIELD.sernumber, null);
			put(LINKFIELD.spisan_flag, null);
			put(LINKFIELD.summa, null);
		}};
		
		
		
		try {
			
			Statement stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(SQL);
			while(rs.next()) {
			EntityLink el =	new EntityLink(rs);
			entityLink.add(el);
			}
			stSelect.close();
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex);
		}
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		super.setConnection(connection);
	}

	@Override
	public List<EntityLink> getResult() {
		// TODO Auto-generated method stub
//		log.debug(SQL+getSqlFilter());
		entityLink.clear();
try {
			
			Statement stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
			while(rs.next()) {
			EntityLink el =	new EntityLink(rs);
			entityLink.add(el);
			}
			stSelect.close();
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex);
		}
		
		
		return entityLink;
	}

	@Override
	public EntityLink getById(int keyField) {
		filter.put(LINKFIELD.Link_oborud_id, "="+keyField);
		EntityLink el=null;
		
		try {
			
			Statement stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
			while(rs.next()) {
			el =	new EntityLink(rs);
			
			}
			stSelect.close();
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex);
		}
		
		return el;
	}
	
	@Override
	public void orderBy(LINKFIELD field, ORDER order) {
		// TODO Auto-generated method stub
		super.orderBy(field, order);
	}

	@Override
	public void filterBy(ArrayList<String> filters, boolean add) {
		if (!filters.isEmpty()) {
		if(!add ) {
			sqlFilter.setLength(0);
			sqlFilter.append(" where ");
			String and="";
			for(String condition : filters) {
				sqlFilter.append(and + " " + condition);
				and = " and ";
			}
		}
		else {
			
			String and=" and ";
			for(String condition : filters) {
				sqlFilter.append(and + " " + condition);
				
			}
		}
		}
	}

	@Override
	public void insert(Map<String, String[]> listParams) {
		// TODO Auto-generated method stub
		super.insert(listParams);
	}

	@Override
	public void update(Map<String, String[]> listParams) {
		// TODO Auto-generated method stub
		super.update(listParams);
	}

	@Override
	public void delete(String[] listParams) {
		if (listParams!=null && listParams.length>0) {
			try {
				
				PreparedStatement stDelete = connection.prepareStatement("DELETE FROM `LinkOborud` WHERE `Link_oborud_id`=?");
				for (String srow : listParams) {
				int row = Integer.parseInt(srow);
				stDelete.setInt(1, row);
				stDelete.addBatch();
				}
				stDelete.executeBatch();
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				log.error(e);
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			
		
			
		}
		}

	}

	@Override
	public String getKeyField() {
		// TODO Auto-generated method stub
		return super.getKeyField();
	}

	@Override
	public void setKeyField(String keyField) {
		// TODO Auto-generated method stub
		super.setKeyField(keyField);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected boolean isConnection() {
		// TODO Auto-generated method stub
		return super.isConnection();
	}


	
//	public void setFilter(LINKFIELD field, String value) {
//		filter.put(field, value);
//		
//	}
//	public String getSqlFilter() {
//		
//		StringBuilder sql = new StringBuilder();
//		if (!filter.isEmpty()) {
//			sql.append(" where ");
//			String and="";
//			for(Map.Entry<LINKFIELD, String> entry : filter.entrySet()) {
//				if(!StringUtils.isBlank(entry.getValue())) {
//			sql.append(and+" "+entry.getKey().name()+" "+entry.getValue());
//			and=" and ";}
//		}
//		}
//		
//		return sql.toString();
//	}
//	public void clearFilter() {
//		filter.replaceAll(null);
////		for(Map.Entry<FIELD, String> entry : filter.entrySet()) {
////			entry.setValue(null);
////
////		}
////		
////		filter.put(FIELD.Link_oborud_id, null);
////		filter.put(FIELD.date_begin, null);
////		filter.put(FIELD.gruppa_id, null);
////		filter.put(FIELD.invnumber, null);
////		filter.put(FIELD.material_id, null);
////		filter.put(FIELD.name, null);
////		filter.put(FIELD.note, null);
////		filter.put(FIELD.oborud_id, null);
////		filter.put(FIELD.sernumber, null);
////		filter.put(FIELD.spisan_flag, null);
////		filter.put(FIELD.summa, null);
//	}
//	public void clearFilterNotKey() {
//		String keyValue = filter.get(LINKFIELD.Link_oborud_id);
//		filter.replaceAll(null);
//		filter.put(LINKFIELD.Link_oborud_id, keyValue);
//	}
	
}


