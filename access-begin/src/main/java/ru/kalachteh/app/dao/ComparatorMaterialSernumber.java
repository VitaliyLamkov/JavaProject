package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialSernumber implements Comparator<EntityMaterial>{
	@Override
	public int compare(EntityMaterial o1, EntityMaterial o2) {
		if (o1.getSernumber() == null && o2.getSernumber()  != null) return -1;
		if (o1.getSernumber()  != null && o2.getSernumber()  == null) return 1;
		if (o1.getSernumber()  == null && o2.getSernumber()  == null) return 0;
		return o1.getSernumber().compareTo(o2.getSernumber());
	}

}
