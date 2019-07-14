package ru.kalachteh.app.control.web;

import java.util.ArrayList;

import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.EntityOtv;

public class FormControlEditOtv {
	EntityOtv ovetst;
	ArrayList<EntityOtdel> otdel;
	ArrayList<EntityPost> post;
	String action;
	public FormControlEditOtv() {
		action = "editpost";
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAction() {
		return action;
	}
	public void setOvetst(EntityOtv ovetst) {
		this.ovetst = ovetst;
	}
	public EntityOtv getOvetst() {
		return ovetst;
	}
	public ArrayList<EntityOtdel> getOtdel() {
		return otdel;
	}
	public void setOtdel(ArrayList<EntityOtdel> otdel) {
		this.otdel = otdel;
	}
	public ArrayList<EntityPost> getPost() {
		return post;
	}
	public void setPost(ArrayList<EntityPost> post) {
		this.post = post;
	}
	
	
	

}
