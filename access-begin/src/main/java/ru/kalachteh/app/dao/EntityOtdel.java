package ru.kalachteh.app.dao;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class EntityOtdel extends AbstractDaoEntity  {
	
	int otdelId;
	
	String name;
	int otvId;
	
	public EntityOtdel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public EntityOtdel(int otdelId, String name, int otvId) {
		setOtdelId(otdelId);
		setName(name);
		setOtvId(otvId);

	}
	
	
	public EntityOtdel(ResultSet rs) {

		try {
			setOtdelId(rs.getInt("otdel_id"));
			setName(rs.getString("name"));
			setOtvId(rs.getInt("otv_id"));
		} catch (SQLException e) {
			
			e.printStackTrace();
			Logger.getRootLogger().error(e);
		}
		
	}
	
	
	public int getOtdelId() {
		return otdelId;
	}

	public void setOtdelId(int otdelId) {
		this.otdelId = otdelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOtvId() {
		return otvId;
	}

	public void setOtvId(int otvId) {
		this.otvId = otvId;
	}


}
