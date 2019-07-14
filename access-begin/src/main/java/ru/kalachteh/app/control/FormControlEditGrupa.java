package ru.kalachteh.app.control;

import ru.kalachteh.app.dao.EntityGruppa;

public class FormControlEditGrupa {
EntityGruppa eg;
String action = "editpost"; 
public FormControlEditGrupa() {
	// TODO Auto-generated constructor stub
}
public FormControlEditGrupa(EntityGruppa eg) {
	setEg(eg);
}
public void setEg(EntityGruppa eg) {
	this.eg = eg;
}
public EntityGruppa getEg() {
	return eg;
}

public void setAction(String action) {
	this.action = action;
}
public String getAction() {
	return action;
}
}
