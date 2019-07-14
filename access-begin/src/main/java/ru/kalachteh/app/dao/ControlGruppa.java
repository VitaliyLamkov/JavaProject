package ru.kalachteh.app.dao;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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


public class ControlGruppa extends AbstractDaoControl< EntityGruppa, GRUPPAFIELD > {
	private final Logger log = Logger.getLogger(this.getClass());
	List<EntityGruppa> entityGtupps = new ArrayList<EntityGruppa>();
 public ControlGruppa(Connection connection) {
	super(connection);
	SQL = "SELECT * FROM `Gruppa`";
	sqlFilter = new StringBuilder();
	orderField=GRUPPAFIELD.NAME;
	filter = new HashMap<GRUPPAFIELD, String>(){{
		put(GRUPPAFIELD.Gruppa_id, null);
		put(GRUPPAFIELD.NAME, null);
		put(GRUPPAFIELD.NOTE, null);
	}};
	setKeyField("Gruppa_id");
	try {
		 Statement st = connection.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 while (rs.next()) {
			 EntityGruppa ed = new EntityGruppa(rs);
			 entityGtupps.add(ed);
			 
		 }
		 st.close();
		 rs.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		log.error(e);
	}
}
@Override
public List<EntityGruppa> getResult() {
	// TODO Auto-generated method stub
	return entityGtupps;
}
@Override
public EntityGruppa getById(int keyField) {
	// TODO Auto-generated method stub
	Statement st;
	try {
		
		st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM `Gruppa` WHERE `Gruppa_id` = "+keyField);
		while (rs.next()) {
		return new EntityGruppa(rs);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error(e);
	}
	
	return null;
}
@Override
public List<EntityGruppa> refresh() {
	entityGtupps.clear();
	try {
		log.debug(SQL+getSqlFilter());
		Statement stSelect = connection.createStatement();
		ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
		while(rs.next()) {
			EntityGruppa el =	new EntityGruppa(rs);
		entityGtupps.add(el);
		}
		stSelect.close();
		rs.close();
	}
	catch (SQLException ex) {
		ex.printStackTrace();
		log.error(ex);	
	}
	
	orderBy(orderField, order);

	
	return entityGtupps;
	
}
@Override
public void orderBy(GRUPPAFIELD field, ORDER order) {
	orderField=field;
	this.order=order;
	
	Comparator comparator = null;
	switch (field) {
	case NAME:
		comparator = new ComparatorGruppaName();
		break;
	case NOTE:
		comparator = new ComparatorGruppaNote();
		break;
	}
	if (comparator != null && order==ORDER.ASC) {
		java.util.Collections.sort(entityGtupps, comparator);
	}

	if (comparator != null && order == ORDER.DESC) {
		java.util.Collections.sort(entityGtupps, java.util.Collections.reverseOrder(comparator));
	}

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
						"INSERT INTO `Gruppa` " + 
						"(`Name`, `Note`) " + 
						"VALUES(?, ?)" );
		stInsert.setString(1, listParams.get("name")[0]);
		stInsert.setString(2, listParams.get("note")[0]);
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
				"UPDATE `Gruppa`" + 
				"SET `Name`=?, `Note`=?" + 
				"WHERE `Gruppa_id`=?" + 
				"" );
		stUpdate.setString(1, listParams.get("name")[0]);
		stUpdate.setString(2, listParams.get("note")[0]);
		stUpdate.setInt(3, Integer.valueOf(listParams.get("gruppaId")[0]));
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
			
			PreparedStatement stDelete = connection.prepareStatement("DELETE FROM `Gruppa` WHERE `Gruppa_id`=?");
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
 
 
}
