package ru.kalachteh.app.control;
import java.util.Collection;

import ru.kalachteh.app.dao.EntityOtv;

public class FormControlOtv {
	private Collection<EntityOtv> entityOtv;
	public FormControlOtv() {
		// TODO Auto-generated constructor stub
	}
	public void setEntityOtv(Collection<EntityOtv>  entityOtv) {
		this.entityOtv = entityOtv;
	}
	public Collection<EntityOtv>  getEntityOtv() {
		return entityOtv;
	}

}
