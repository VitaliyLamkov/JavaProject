package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialDatebegin implements Comparator<EntityMaterial> {
 @Override
public int compare(EntityMaterial o1, EntityMaterial o2) {
	 if (o1.getMatDateBegin() == null && o2.getMatDateBegin() != null) return -1;
		if (o1.getMatDateBegin() != null && o2.getMatDateBegin() == null) return 1;
		if (o1.getMatDateBegin() == null && o2.getMatDateBegin() == null) return 0;
		
		return o1.getMatDateBegin().compareTo(o2.getMatDateBegin());

}
}
