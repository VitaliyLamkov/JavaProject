package ru.kalachteh.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EntityOtv extends AbstractDaoEntity {
	int otvId;
	int personnelId;
	String atterney;
	String surname;
	String name;
	String patronymic;
	String passportNumber;
	String phon;
	int sign;
	String postName;
	int otdelId;
	int postId;
	public EntityOtv() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityOtv(int otvId,
	int personnelId,
	String atterney,
	String surname,
	String name,
	String patronymic,
	String passportNumber,
	String phon,
	int sign,
	String postName,
	int otdelId,
	int postId) {
		setOtvId(otvId);
		setPersonnelId(personnelId);
		setAtterney(atterney);
		setSurname(surname);
		setName(name);
		setPatronymic(patronymic);
		setPassportNumber(passportNumber);
		setPhon(phon);
		setSign(sign);
		setPostName(postName);
		setOtdelId(otdelId);
		setPostId(postId);
		
	}
	
	public EntityOtv(ResultSet rs) {
		try {
			setOtvId(rs.getInt("otv_id"));
			setPersonnelId(rs.getInt("personnel_id"));
		    setAtterney(rs.getString("atterney"));
		    setSurname(rs.getString("surname"));
		    setName(rs.getString("name"));
		    setPatronymic(rs.getString("patronymic"));
		    setPassportNumber(rs.getString("passport_number"));
		    setPhon(rs.getString("phon"));
		    setSign(rs.getInt("sign"));
		    setPostName(rs.getString("post_name"));
		    setOtdelId(rs.getInt("otdel_id"));
		    setPostId(rs.getInt("post_id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int getOtvId() {
		return otvId;
	}

	public void setOtvId(int otvId) {
		this.otvId = otvId;
	}

	public int getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(int personnelId) {
		this.personnelId = personnelId;
	}

	public String getAtterney() {
		return atterney;
	}

	public void setAtterney(String atterney) {
		this.atterney = atterney;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPhon() {
		return phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public int getOtdelId() {
		return otdelId;
	}

	public void setOtdelId(int otdelId) {
		this.otdelId = otdelId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPostId() {
		return postId;
	}
	
	
}
