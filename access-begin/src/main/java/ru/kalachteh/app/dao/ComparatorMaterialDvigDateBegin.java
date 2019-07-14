package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialDvigDateBegin implements Comparator<EntityMaterial> {
 @Override
public int compare(EntityMaterial o1, EntityMaterial o2) {
	 if (o1.getDvigDateBegin() == null && o2.getDvigDateBegin() != null) return -1;
		if (o1.getDvigDateBegin() != null && o2.getDvigDateBegin() == null) return 1;
		if (o1.getDvigDateBegin() == null && o2.getDvigDateBegin() == null) return 0;
//		
		return o1.getDvigDateBegin().compareTo(o2.getDvigDateBegin());
	 
//	 if (o1.getDvigDateBegin().isBefore(o2.getDvigDateBegin())) return -1;
//	 if (o1.getDvigDateBegin().isAfter(o2.getDvigDateBegin())) return 1;
//	 if (o1.getDvigDateBegin().isEqual(o2.getDvigDateBegin())) return 0;
//return 0;
}
}
