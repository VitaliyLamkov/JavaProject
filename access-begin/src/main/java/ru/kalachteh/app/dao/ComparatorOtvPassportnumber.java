package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorOtvPassportnumber implements Comparator<EntityOtv>{
	@Override
	public int compare(EntityOtv o1, EntityOtv o2) {
		if (o1.getPassportNumber() == null && o2.getPassportNumber() != null) return -1;
		if (o1.getPassportNumber() != null && o2.getPassportNumber() == null) return 1;
		if (o1.getPassportNumber() == null && o2.getPassportNumber() == null) return 0;
		return o1.getPassportNumber().compareTo(o2.getPassportNumber());
	}
}
