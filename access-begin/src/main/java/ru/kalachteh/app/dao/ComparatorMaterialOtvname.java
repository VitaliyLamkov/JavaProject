package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialOtvname implements Comparator<EntityMaterial> {
 @Override
public int compare(EntityMaterial o1, EntityMaterial o2) {
	 if (o1.getOtvname() == null && o2.getOtvname() != null) return -1;
		if (o1.getOtvname() != null && o2.getOtvname() == null) return 1;
		if (o1.getOtvname() == null && o2.getOtvname() == null) return 0;
		
		return o1.getOtvname().compareTo(o2.getOtvname());

}
}
