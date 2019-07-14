package ru.kalachteh.app.control;
import java.util.Collection;

import ru.kalachteh.app.dao.EntityMaterial;

public class FormControlMaterial {
	private Collection<EntityMaterial> material;
	
	public void setMaterial(Collection material) {
		this.material = material;
	}
	public Collection getMaterial() {
		return material;
	}
	
	public void initForm(Collection matrrial) {
		setMaterial(matrrial);
	}

}
