package ru.kalachteh.app.control;
import java.util.Collection;

import ru.kalachteh.app.dao.EntityOtdel;

public class FormControlOtdel {
    private Collection<EntityOtdel> entityOtdel;
    
	public FormControlOtdel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEntityOtdel(Collection<EntityOtdel> entityOtdel) {
		this.entityOtdel = entityOtdel;
	}
	public Collection<EntityOtdel> getEntityOtdel() {
		return entityOtdel;
	}
}
