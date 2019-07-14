package ru.kalachteh.app.control.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import ru.kalachteh.app.dao.AbstractDaoControl;
import ru.kalachteh.app.dao.ComparatorGruppaName;
import ru.kalachteh.app.dao.ComparatorGruppaNote;
import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.ORDER;



public class ControlPost extends AbstractDaoControl<EntityPost, POSTFIELD> {
	private final Logger log = Logger.getLogger(this.getClass());
	List<EntityPost> entityPost = new ArrayList<EntityPost>(); 

	public ControlPost(Connection connection) {
		super(connection);
		SQL = "SELECT `post_id`, `name`, `name_r`, `name_t`, `name_v`, `name_p`, `name_d` " + 
				" FROM `Post`";
		sqlFilter = new StringBuilder();
		orderField=POSTFIELD.NAME;
		filter = new HashMap<POSTFIELD, String>(){{
			put(POSTFIELD.POST_ID, null);
			put(POSTFIELD.NAME, null);
		}};
		setKeyField("Gruppa_id");
		try {
			 Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery(SQL);
			 while (rs.next()) {
				 EntityPost ed = new EntityPost(rs);
				 entityPost.add(ed);
				 
			 }
			 st.close();
			 rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
		}
	}

	@Override
	public List<EntityPost> getResult() {
		// TODO Auto-generated method stub
		return entityPost;
	}

	@Override
	public List<EntityPost> refresh() {
		entityPost.clear();
		try {
			
			Statement stSelect = connection.createStatement();
			ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
			while(rs.next()) {
				EntityPost el =	new EntityPost(rs);
				entityPost.add(el);
			}
			stSelect.close();
			rs.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex);	
		}
		
		orderBy(orderField, order);

		
		return entityPost;// TODO Auto-generated method stub
		
	}
	
	@Override
	public void orderBy(POSTFIELD field, ORDER order) {
		orderField=field;
		this.order=order;
		
		Comparator comparator = null;
		switch (field) {
		case NAME:
			comparator = new ComparatorPostName();
			break;
		
		}
		if (comparator != null && order==ORDER.ASC) {
			java.util.Collections.sort(entityPost, comparator);
		}

		if (comparator != null && order == ORDER.DESC) {
			java.util.Collections.sort(entityPost, java.util.Collections.reverseOrder(comparator));
		}
	}
	

}
