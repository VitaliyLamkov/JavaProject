package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorOtvPost  implements Comparator<EntityOtv>{
	@Override
	public int compare(EntityOtv o1, EntityOtv o2) {
		if (o1.getPostName() == null && o2.getPostName() != null) return -1;
		if (o1.getPostName() != null && o2.getPostName() == null) return 1;
		if (o1.getPostName() == null && o2.getPostName() == null) return 0;
		return o1.getPostName().compareTo(o2.getPostName());
	}
}
