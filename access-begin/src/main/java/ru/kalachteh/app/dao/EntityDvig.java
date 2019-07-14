package ru.kalachteh.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import ru.kalachteh.app.control.web.MainServlet;

import java.sql.Date;

public class EntityDvig extends AbstractDaoEntity {
	private static final Logger log =  Logger.getLogger(MainServlet.class);
	int dvigId;
	String prichina;
	int typePrichina;
	int otvId;
	LocalDate dateBegin;
	LocalDate dateEnd;
	int materialId;
	int otdelId;
	String otdName;
	String otvName;
	String prichinaStr;
	
	public EntityDvig() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityDvig(int dvigId,
	String prichina,
	int typePrichina,
	int otvId,
	LocalDate dateBegin,
	LocalDate dateEnd,
	int materialId,
	int otdelId,
	String otdName,
	String otvName,
	String prichinaStr) {
		setDvigId(dvigId);
		setPrichina(prichinaStr);
		setTypePrichina(typePrichina);
		setOtvId(otvId);
		setDateBegin(dateBegin);
		setDateEnd(dateEnd);
		setMaterialId(materialId);
		setOtdelId(otdelId);
		setOtdName(otdName);
		setOtvName(otvName);
		setPrichina(prichinaStr);
		
	}
	public EntityDvig(ResultSet rs) {
		try {
			setDvigId(rs.getInt("dvig_id"));
			setPrichina(rs.getString("prichina"));
			setTypePrichina(rs.getInt("typeprichina"));
			setOtvId(rs.getInt("otv_id"));
			setDateBegin( isDateNull(rs, "datebegin")== false? rs.getDate("datebegin").toLocalDate():null);
			setDateEnd( isDateNull(rs, "dateend")== false ? rs.getDate("dateend").toLocalDate():null);
			setMaterialId(rs.getInt("material_id"));
			setOtdelId(rs.getInt("otdel_id"));
			setOtdName(rs.getString("otdname"));
			setOtvName(rs.getString("otvname"));
			setPrichina(rs.getString("prichinastr"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		} catch (NullPointerException e){
			e.printStackTrace();
			log.error(e);
		}
		
	}
	private boolean isDateNull(ResultSet set, String col) {
		try {
			java.sql.Date date = set.getDate(col);
			return set.wasNull();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}catch (NullPointerException e){
			e.printStackTrace();
			log.error(e);
		}
		return true;
		
	}

	public int getDvigId() {
		return dvigId;
	}

	public void setDvigId(int dvigId) {
		this.dvigId = dvigId;
	}

	public String getPrichina() {
		return prichina;
	}

	public void setPrichina(String prichina) {
		this.prichina = prichina;
	}

	public int getTypePrichina() {
		return typePrichina;
	}

	public void setTypePrichina(int typePrichina) {
		this.typePrichina = typePrichina;
	}

	public int getOtvId() {
		return otvId;
	}

	public void setOtvId(int otvId) {
		this.otvId = otvId;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate localDate) {
		this.dateBegin = localDate;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate localDate) {
		this.dateEnd = localDate;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getOtdelId() {
		return otdelId;
	}

	public void setOtdelId(int otdelId) {
		this.otdelId = otdelId;
	}

	public String getOtdName() {
		return otdName;
	}

	public void setOtdName(String otdName) {
		this.otdName = otdName;
	}

	public String getOtvName() {
		return otvName;
	}

	public void setOtvName(String otvName) {
		this.otvName = otvName;
	}

	public String getPrichinaStr() {
		return prichinaStr;
	}

	public void setPrichinaStr(String prichinaStr) {
		this.prichinaStr = prichinaStr;
	}
	
	

	}
