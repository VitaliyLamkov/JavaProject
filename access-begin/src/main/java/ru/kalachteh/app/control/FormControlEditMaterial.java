package ru.kalachteh.app.control;

import java.util.ArrayList;
import java.util.Date;

import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.EntityMaterial;

public class FormControlEditMaterial {
	private String action;
	private EntityMaterial mat;
	private ArrayList<EntityGruppa> listGruppa;
	
	public FormControlEditMaterial() {
		// TODO Auto-generated constructor stub
//		this.matDateBegin =  new java.util.Date();
		
	}
	
	public ArrayList<EntityGruppa> getListGruppa() {
		return listGruppa;
	}

	public void setListGruppa(ArrayList<EntityGruppa> listGruppa) {
		this.listGruppa = listGruppa;
	}
	public void setMat(EntityMaterial mat) {
		this.mat = mat;
	}
	public EntityMaterial getMat() {
		return mat;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	public String getAction() {
		return action;
	}
	
		
}
