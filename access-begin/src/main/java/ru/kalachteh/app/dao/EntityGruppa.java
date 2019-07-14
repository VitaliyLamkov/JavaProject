package ru.kalachteh.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityGruppa  extends AbstractDaoEntity{
	int gruppaId;
	String name;
	String note;
	
	public EntityGruppa() {
		// TODO Auto-generated constructor stub
	}
	public EntityGruppa(int gruppaId,
	String name,
	String note) {
		
		setGruppaId(gruppaId);
		setName(name);
		setNote(note);
		
	}
	public EntityGruppa(ResultSet rs) {
		
		try {
			setGruppaId(rs.getInt("gruppa_id"));
			setName(rs.getString("name"));
			setNote(rs.getString("note"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getGruppaId() {
		return gruppaId;
	}
	public void setGruppaId(int gruppaId) {
		this.gruppaId = gruppaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
