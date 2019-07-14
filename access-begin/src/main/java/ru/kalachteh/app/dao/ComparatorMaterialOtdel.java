package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialOtdel implements Comparator<EntityMaterial>{
 @Override
public int compare(EntityMaterial o1, EntityMaterial o2) {
	 if (o1.getOtdname() == null && o2.getOtdname() != null) return -1;
		if (o1.getOtdname() != null && o2.getOtdname() == null) return 1;
		if (o1.getOtdname() == null && o2.getOtdname() == null) return 0;
		return o1.getOtdname().compareTo(o2.getOtdname());
}
}
