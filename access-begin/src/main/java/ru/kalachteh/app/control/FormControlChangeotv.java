package ru.kalachteh.app.control;

import ru.kalachteh.app.dao.EntityMaterial;
import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.EntityOtv;
import java.util.ArrayList;

public class FormControlChangeotv {
	
	ArrayList<EntityMaterial> em;
	  ArrayList<EntityOtv> listOtv;
	  ArrayList<EntityOtdel> listOtdel; 
	  
	  public FormControlChangeotv() {
		// TODO Auto-generated constructor stub
	}
	  
  public ArrayList<EntityMaterial> getEm() {
		return em;
	}
	public void setEm(ArrayList<EntityMaterial> em) {
		this.em = em;
	}
	public ArrayList<EntityOtv> getListOtv() {
		return listOtv;
	}
	public void setListOtv(ArrayList<EntityOtv> listOtv) {
		this.listOtv = listOtv;
	}
	public ArrayList<EntityOtdel> getListOtdel() {
		return listOtdel;
	}
	public void setListOtdel(ArrayList<EntityOtdel> listOtdel) {
		this.listOtdel = listOtdel;
	}

}
