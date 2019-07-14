package ru.kalachteh.app.dao;
import java.util.ArrayList;
import java.util.Arrays;
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

public class ControlOtv extends AbstractDaoControl<EntityOtv, OTVFIELD> {
	private final Logger log = Logger.getLogger(this.getClass());
	List<EntityOtv> entityOtv = new ArrayList<EntityOtv>();
	
	
public ControlOtv(Connection connection) {
	// TODO Auto-generated constructor stub
	super(connection);
	SQL = "SELECT * FROM `ViewOtv`";
	sqlFilter = new StringBuilder();
	orderField = OTVFIELD.NAME;
	filter = new HashMap<OTVFIELD, String>(){{
		put(OTVFIELD.OTV_ID, null);
		put(OTVFIELD.NAME, null);
		put(OTVFIELD.PASSPORT_NUMBER, null);
		put(OTVFIELD.PHON, null);
		put(OTVFIELD.POST_NAME, null);
	}};
	setKeyField("otv_id");
	
	try {
		 Statement st = connection.createStatement();
		 ResultSet rs = st.executeQuery(SQL);
		 while (rs.next()) {
			 EntityOtv eo = new EntityOtv(rs);
			    entityOtv.add(eo);
		 }
		 
		 st.close();
		 rs.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		log.error(e);
	}
}


@Override
public void setConnection(Connection connection) {
	// TODO Auto-generated method stub
	super.setConnection(connection);
}
@Override
public List<EntityOtv> getResult() {
	// TODO Auto-generated method stub
	return entityOtv;
}

@Override
public EntityOtv getById(int keyFieldValue) {
	// TODO Auto-generated method stub
		try { 
			  Statement statement = connection.createStatement();
			  ResultSet resultSet = statement.executeQuery(SQL + " WHERE `"+this.keyField+"` = " + keyFieldValue);
			  while(resultSet.next()) {
				  return new EntityOtv(resultSet); 
				 	  }
			  
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return null;
}


@Override
public void orderBy(OTVFIELD field, ORDER order) {
	orderField=field;
	this.order=order;
	
	Comparator comparator = null;
	switch (field) {
	case NAME:
		comparator = new ComparatorOtvName();
		break;
	case PASSPORT_NUMBER:
		comparator = new ComparatorOtvPassportnumber();
		break;
	case PHON:
		comparator = new ComparatorOtvPhon();
		break;
	case POST_NAME:
		comparator = new ComparatorOtvPost();
		break;
	}
	if (comparator != null && order==ORDER.ASC) {
		java.util.Collections.sort(entityOtv, comparator);
	}

	if (comparator != null && order == ORDER.DESC) {
		java.util.Collections.sort(entityOtv, java.util.Collections.reverseOrder(comparator));
	}

}


@Override
public void filterBy(ArrayList<String> filters, boolean add) {
	// TODO Auto-generated method stub
	super.filterBy(filters, add);
}

@Override
public List<EntityOtv> refresh() {
	entityOtv.clear();
	try {
		log.debug(SQL+getSqlFilter());
		Statement stSelect = connection.createStatement();
		ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
		while(rs.next()) {
			EntityOtv el =	new EntityOtv(rs);
		entityOtv.add(el);
		}
		stSelect.close();
		rs.close();
	}
	catch (SQLException ex) {
		ex.printStackTrace();
		log.error(ex);	
	}
	
	orderBy(orderField, order);

	
	return entityOtv;
	
}

//stmt.addBatch();
//}
//// Выполняем все запросы разом
//stmt.executeBatch();

@Override
public void insert(Map<String, String[]> listParams) {
	log.debug("first insert begin");
	try {
		connection.setAutoCommit(false);
		
		PreparedStatement stInsert = connection.prepareStatement(
				"INSERT INTO `Personnel` " + 
				"(`Otdel_id`, `Surname`, `Name`, `Patronymic`, `phone`) " + 
				"VALUES(?, ?, ?, ?, ? )" );
		
		stInsert.setInt(1, Integer.valueOf(listParams.get("otdelId")[0]));
		stInsert.setString(2, listParams.get("surname")[0]);
		stInsert.setString(3, listParams.get("name")[0]);
		stInsert.setString(4, listParams.get("patronymic")[0]);
		stInsert.setString(5, listParams.get("phon")[0]);
		
		
		int affectedRows = stInsert.executeUpdate();
			
//				try {
					if(affectedRows>0) {
						log.debug("second insert begin");
				long key;
				 try (ResultSet generatedKeys = stInsert.getGeneratedKeys()) {
			            if (generatedKeys.next()) {
			               key =  generatedKeys.getLong(1);
			            }
			            else {
			                throw new SQLException("Creating user failed, no ID obtained.");
			            }
				 }
		stInsert = connection.prepareStatement(
				"INSERT INTO `Otv` " + 
				"(`personnel_id`, `otdel_id`, `phon`,  `post_id`) " + 
				"VALUES(?, ?, ?, ? )");
		stInsert.setLong(1,key);
		
		stInsert.setInt(2, Integer.valueOf(listParams.get("otdelId")[0]));
		
		stInsert.setString(3, listParams.get("phon")[0]);
		
		stInsert.setInt(4, Integer.valueOf(listParams.get("postId")[0]));
		
		stInsert.executeUpdate();
		connection.commit();
		stInsert.close();
					}
					else {
						connection.rollback();
					}
//			} catch (SQLException e) {
//				connection.rollback();
//				
//				
//				e.printStackTrace();
//				log.error(e);
//			}
		
//					connection.commit();
//					stInsert.close();
		
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
public void update(Map<String, String[]> listParams) {
	try {
		connection.setAutoCommit(false);
		
		PreparedStatement stUpdate = connection.prepareStatement(
				"UPDATE `Personnel` " + 
				"SET `Otdel_id`=?, `Surname`=?, `Name`=?, `Patronymic`=?, `phone`=? " + 
				"WHERE `Personnel_id`=?");
		
		stUpdate.setInt(1, Integer.valueOf(listParams.get("otdelId")[0]));
		stUpdate.setString(2, listParams.get("surname")[0]);
		stUpdate.setString(3, listParams.get("name")[0]);
		stUpdate.setString(4, listParams.get("patronymic")[0]);
		stUpdate.setString(5, listParams.get("phon")[0]);
		stUpdate.setInt(6, Integer.valueOf(listParams.get("personnelId")[0]));
		
		int i = stUpdate.executeUpdate();

		stUpdate = connection.prepareStatement(
				"UPDATE `Otv` " + 
				"SET `otdel_id`=?, `phon`=?,  `post_id`=?" + 
				"WHERE `otv_id`=?");
		stUpdate.setInt(1, Integer.valueOf(listParams.get("otdelId")[0]));
		stUpdate.setString(2, listParams.get("phon")[0]);
		stUpdate.setInt(3, Integer.valueOf(listParams.get("postId")[0]));
		stUpdate.setInt(4, Integer.valueOf(listParams.get("otvId")[0]));
		i = stUpdate.executeUpdate();
		connection.commit();
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
	try {
		connection.setAutoCommit(false);
		PreparedStatement stDeletePersonnel = connection.prepareStatement("DELETE FROM `Personnel` " + 
				"WHERE `Personnel_id`=? ");
		PreparedStatement	stDeleteOtv = connection.prepareStatement("DELETE FROM `Otv`" + 
						"WHERE `Personnel_id`=?");
		int idField;
		for (String idFieldStr: listParams) {
			idField = Integer.parseInt(idFieldStr);
		stDeletePersonnel.setInt(1, idField);
		stDeletePersonnel.addBatch();
		stDeleteOtv.setInt(1, idField);
		stDeleteOtv.addBatch();
		}
		stDeletePersonnel.executeBatch();
		stDeleteOtv.executeBatch();
		stDeletePersonnel.close();
		stDeleteOtv.close();
		
		connection.commit();
		
	} catch(NumberFormatException e) {
		e.printStackTrace();
		log.error(e);
	}
	catch (SQLException e) {
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			log.error(e);
			
		}
		e.printStackTrace();
		log.error(e);
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
