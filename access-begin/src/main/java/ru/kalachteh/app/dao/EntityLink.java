package ru.kalachteh.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;

public class EntityLink {
	private final Logger log = Logger.getLogger(this.getClass());
	
	LocalDate dateBegin;
	int gruppaId;
	String invnumber;
	int linkOborudId;
	int materialId;
	String name;
	String note;
	int oborudId;
	String sernumber;
	int spisanFlag;
	double summa;
	
	public EntityLink() {
		// TODO Auto-generated constructor stub
	}
	

	
	public EntityLink(ResultSet rs) {
		
		try {
		setDateBegin( AppUtils.isDateNull(rs, "date_begin")== false? rs.getDate("date_begin").toLocalDate():null);
		setGruppaId(rs.getInt("gruppa_id"));
		setInvnumber(rs.getString("invnumber"));
		setLinkOborudId(rs.getInt("Link_oborud_id"));
		setMaterialId(rs.getInt("material_id"));
		setName(rs.getString("name"));
		setNote(rs.getString("note"));
		setOborudId(rs.getInt("oborud_id"));
		setSernumber(rs.getString("sernumber"));
		setSpisanFlag(rs.getInt("spisan_flag"));
		setSumma(rs.getDouble("summa"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}catch (NullPointerException e){
			e.printStackTrace();
			log.error(e);
		}
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public int getGruppaId() {
		return gruppaId;
	}

	public void setGruppaId(int gruppaId) {
		this.gruppaId = gruppaId;
	}

	public String getInvnumber() {
		return invnumber;
	}

	public void setInvnumber(String invnumber) {
		this.invnumber = invnumber;
	}

	public int getLinkOborudId() {
		return linkOborudId;
	}

	public void setLinkOborudId(int linkOborudId) {
		this.linkOborudId = linkOborudId;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
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

	public int getOborudId() {
		return oborudId;
	}

	public void setOborudId(int oborudId) {
		this.oborudId = oborudId;
	}

	public String getSernumber() {
		return sernumber;
	}

	public void setSernumber(String sernumber) {
		this.sernumber = sernumber;
	}

	public int getSpisanFlag() {
		return spisanFlag;
	}

	public void setSpisanFlag(int spisanFlag) {
		this.spisanFlag = spisanFlag;
	}

	public double getSumma() {
		return summa;
	}

	public void setSumma(double summa) {
		this.summa = summa;
	}

	
	
}
