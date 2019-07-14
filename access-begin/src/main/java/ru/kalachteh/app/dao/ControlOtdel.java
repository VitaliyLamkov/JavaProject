package ru.kalachteh.app.dao;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.Console;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControlOtdel extends AbstractDaoControl<EntityOtdel, OTDELFIELD> {
	
	private final Logger log = Logger.getLogger(this.getClass());
	List<EntityOtdel> entityOtdel = new ArrayList<EntityOtdel>();
	
	
	public ControlOtdel(Connection connection) {
		super(connection);
		
		SQL = "SELECT * FROM `otdel`";
		sqlFilter = new StringBuilder();
		orderField = OTDELFIELD.NAME;
		filter  = new HashMap<OTDELFIELD, String>(){{
			put(OTDELFIELD.OTDEL_ID, null);
			put(OTDELFIELD.NAME, null);
		}};
		setKeyField("otdel_id");
		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				EntityOtdel eo = new EntityOtdel(rs);
				entityOtdel.add(eo);
			}
			
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EntityOtdel> getResult() {
		// TODO Auto-generated method stub
		return entityOtdel;
	}

	@Override
	public EntityOtdel getById(int keyField) {
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `otdel` WHERE `otdel_id` = " + keyField);
			while(rs.next()) {
				return new EntityOtdel(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void orderBy(OTDELFIELD field, ORDER order) {
		
		orderField=field;
		this.order=order;
		
		Comparator comparator = null;
		switch (field) {
		case NAME:
			log.debug("ComparatorOtdelName");
			comparator = new ComparatorOtdelName();
			break;
		}
		if (comparator != null && order==ORDER.ASC) {
			java.util.Collections.sort(entityOtdel, comparator);
		}

		if (comparator != null && order == ORDER.DESC) {
			java.util.Collections.sort(entityOtdel, java.util.Collections.reverseOrder(comparator));
		}
	}
	public List<EntityOtdel> refresh() {
		entityOtdel.clear();
		try {
			log.debug(SQL+getSqlFilter());
			Statement stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
			while(rs.next()) {
				EntityOtdel el =	new EntityOtdel(rs);
			entityOtdel.add(el);
			}
			stSelect.close();
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex);	
		}
		
		orderBy(orderField, order);

		
		return entityOtdel;
		
	}

	@Override
	public void filterBy(ArrayList<String> filters, boolean add) {
		// TODO Auto-generated method stub
		super.filterBy(filters, add);
	}

	@Override
	public void insert(Map<String, String[]> listParams) {
		try {
		
			PreparedStatement stInsert = connection.prepareStatement(
							"INSERT INTO `otdel` " + 
							"(`name`) " + 
							"VALUES(?)");
			stInsert.setString(1, listParams.get("name")[0]);
			stInsert.execute();

			stInsert.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log.error(e);
			}
		}
	}
@Override
	public void update(Map<String, String[]> listParams) {
	try {
		
		
		PreparedStatement stUpdate = connection.prepareStatement(
				"UPDATE `otdel`" + 
				"SET `Name`=?" + 
				"WHERE `otdel_id`=?");
		stUpdate.setString(1, listParams.get("name")[0]);
		stUpdate.setInt(2, Integer.valueOf(listParams.get("otdelId")[0]));
		stUpdate.execute();

		stUpdate.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error(e);
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			log.error(e1);
		}
	}
}
	@Override
	public void delete(String[] listParams) {
		if (listParams!=null && listParams.length>0) {
			try {
				
				PreparedStatement stDelete = connection.prepareStatement("DELETE FROM `otdel` WHERE `otdel_id`=?");
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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
