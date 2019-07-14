package ru.kalachteh.app.control;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;

import ru.kalachteh.app.dao.EntityDvig;
import ru.kalachteh.app.dao.EntityLink;
import ru.kalachteh.app.dao.EntityMaterial;
import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.EntityOtv;



public class FormControlMaterialCard {
	private EntityMaterial entityMaterial;
	private Collection<EntityDvig> listEntityDvig;
	private List<EntityOtv> listOtv;
	private List<EntityOtdel> listOtdel;
	private List<EntityLink> listLink;
	private HashMap<Integer, String> listPrichina = new HashMap<Integer, String>(){{
		put(0, "поступило");
		put(1, "перемещение");
		put(2, "списали");
		put(3, "украли");
		put(4, "не внедрили");
		put(5, "ремонт");
		put(6, "устарело, но не списали");
		put(7, "в запасе");
	}};
	
	public FormControlMaterialCard() {
		// TODO Auto-generated constructor stub
	}
	public EntityMaterial getEntityMaterial() {
		return entityMaterial;
	}
	public void setEntityMaterial(EntityMaterial entityMaterial) {
		this.entityMaterial = entityMaterial;
	}
	public Collection<EntityDvig> getListEntityDvig() {
		return listEntityDvig;
	}
	public void setListEntityDvig(Collection<EntityDvig> listEntityDvig) {
		this.listEntityDvig = listEntityDvig;
	}
	public void setListOtdel(List<EntityOtdel> listOtdel) {
		this.listOtdel = listOtdel;
	}
	public List<EntityOtdel> getListOtdel() {
		return listOtdel;
	}
	public void setListOtv(List<EntityOtv> listOtv) {
		this.listOtv = listOtv;
	}
	public List<EntityOtv> getListOtv() {
		return listOtv;
	}
//	public void setListPrichina(HashMap<Integer, String> listPrichina) {
//		this.listPrichina = listPrichina;
//	}
	public HashMap<Integer, String> getListPrichina() {
		return listPrichina;
	}
	public void setListLink(List<EntityLink> listLink) {
		this.listLink = listLink;
	}
	public List<EntityLink> getListLink() {
		return listLink;
	}
}
