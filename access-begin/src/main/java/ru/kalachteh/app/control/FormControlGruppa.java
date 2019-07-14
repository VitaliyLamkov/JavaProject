package ru.kalachteh.app.control;
import java.util.Collection;

import ru.kalachteh.app.dao.EntityGruppa;

public class FormControlGruppa {

	private Collection<EntityGruppa> entityGruppa;
	public FormControlGruppa() {
		// TODO Auto-generated constructor stub
	}
public void setEntityGruppa(Collection<EntityGruppa> entityGruppa) {
	this.entityGruppa = entityGruppa;
}
public Collection<EntityGruppa> getEntityGruppa() {
	return entityGruppa;
}
}