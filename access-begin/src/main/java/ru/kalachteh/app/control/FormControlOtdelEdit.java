package ru.kalachteh.app.control;

import ru.kalachteh.app.dao.EntityOtdel;

public class FormControlOtdelEdit {
	private EntityOtdel otdel;
	private String action;
	
	public FormControlOtdelEdit() {
	 action = "editpost";
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAction() {
		return action;
	}
	public void setOtdel(EntityOtdel otdel) {
		this.otdel = otdel;
	}
	public EntityOtdel getOtdel() {
		return otdel;
	}
	

}
