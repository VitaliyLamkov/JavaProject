package ru.kalachteh.app.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;


public class EntityMaterial extends AbstractDaoEntity  {
	private int material_id;
	private String name;
	private String invnumber;
	private LocalDate matDateBegin;
	private String sernumber;
	private String note;
	private String summa;
	private int gruppa_id;
	private int spisan_flag;
	private String grname;
	private LocalDate dvigDateBegin;
	private LocalDate dvigDateEnd;
	private String otvname;
	private String prichinastr;
	private String otdname;
	
	
	
	public EntityMaterial() {
		
	}
	
	public EntityMaterial(ResultSet rs) {
		
		try {
			setMaterial_id(rs.getInt("material_id"));
			setName(rs.getString("name"));
			setMatDateBegin(AppUtils.isDateNull(rs, "date_begin")== false? rs.getDate("date_begin").toLocalDate():null);
			setInvnumber(rs.getString("invnumber"));
			setSernumber(rs.getString("sernumber"));
			setNote(rs.getString("note"));
			setSumma(rs.getString("summa"));
			setGruppa_id(rs.getInt("gruppa_id"));
			setSpisan_flag(rs.getInt("spisan_flag"));
			setGrname( rs.getString("grname"));
			setDvigDateBegin( AppUtils.isDateNull(rs, "datebegin")== false? rs.getDate("datebegin").toLocalDate():null);
			setDvigDateEnd(AppUtils.isDateNull(rs, "dateend")== false? rs.getDate("dateend").toLocalDate():null);
			setOtvname(rs.getString("otvname"));
			setPrichinastr(rs.getString("prichinastr"));
			setOtdname(rs.getString("otdname"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public EntityMaterial(int material_id, 
							String name, 
							String invnumber, 	
							LocalDate date_begin, 
							String sernumber, 
							String note,
							String summa, 
							int gruppa_id, 
							int spisan_flag, 
							String grname,
							LocalDate dvigDateBegin,
							LocalDate dvigDateEnd,
							String otvname,
							String prichinastr,
							String otdname) {
		
		setMaterial_id(material_id);
		setName(name);
		setInvnumber(invnumber);
		setMatDateBegin(date_begin);
		setSernumber(sernumber);
		setNote(note);
		setSumma(summa);
		setGruppa_id(gruppa_id);
		setSpisan_flag(spisan_flag);
		 setGrname( grname);
		 setDvigDateBegin( dvigDateBegin);
		 setDvigDateEnd(dvigDateEnd);
		 setOtvname(otvname);
		 setPrichinastr(prichinastr);
		 setOtdname(otdname);
		
	}

	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInvnumber() {
		return invnumber;
	}

	public void setInvnumber(String invnumber) {
		this.invnumber = invnumber;
	}

	public LocalDate getMatDateBegin() {
		return matDateBegin;
	}

	public void setMatDateBegin(LocalDate matDateBegin) {
		this.matDateBegin = matDateBegin;
	}

	public String getSernumber() {
		return sernumber;
	}

	public void setSernumber(String sernumber) {
		this.sernumber = sernumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSumma() {
		return summa;
	}

	public void setSumma(String summa) {
		this.summa = summa;
	}

	public int getGruppa_id() {
		return gruppa_id;
	}

	public void setGruppa_id(int gruppa_id) {
		this.gruppa_id = gruppa_id;
	}

	public int getSpisan_flag() {
		return spisan_flag;
	}

	public void setSpisan_flag(int spisan_flag) {
		this.spisan_flag = spisan_flag;
	}
	
	

	public String getGrname() {
		return grname;
	}

	public void setGrname(String grname) {
		this.grname = grname;
	}

	public LocalDate getDvigDateBegin() {
		return dvigDateBegin;
	}

	public void setDvigDateBegin(LocalDate dvig_date_begin) {
		this.dvigDateBegin = dvig_date_begin;
	}

	public LocalDate getDvigDateEnd() {
		return dvigDateEnd;
	}

	public void setDvigDateEnd(LocalDate dvig_date_end) {
		this.dvigDateEnd = dvig_date_end;
	}

	public String getOtvname() {
		return otvname;
	}

	public void setOtvname(String otvname) {
		this.otvname = otvname;
	}

	public String getPrichinastr() {
		return prichinastr;
	}

	public void setPrichinastr(String prichinastr) {
		this.prichinastr = prichinastr;
	}

	public String getOtdname() {
		return otdname;
	}

	public void setOtdname(String otdname) {
		this.otdname = otdname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
