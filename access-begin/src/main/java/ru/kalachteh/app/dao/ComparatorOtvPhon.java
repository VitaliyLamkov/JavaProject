package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorOtvPhon  implements Comparator<EntityOtv>{
	@Override
	public int compare(EntityOtv o1, EntityOtv o2) {
		if (o1.getPhon() == null && o2.getPhon() != null) return -1;
		if (o1.getPhon() != null && o2.getPhon() == null) return 1;
		if (o1.getPhon() == null && o2.getPhon() == null) return 0;
		return o1.getPhon().compareTo(o2.getPhon());
	}
}
