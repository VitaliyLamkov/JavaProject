package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorGruppaNote implements Comparator<EntityGruppa> {
	@Override
	public int compare(EntityGruppa o1, EntityGruppa o2) {
		if (o1.getNote() == null && o2.getNote() != null) return -1;
		if (o1.getNote() != null && o2.getNote() == null) return 1;
		if (o1.getNote() == null && o2.getNote() == null) return 0;
		return o1.getNote().compareTo(o2.getNote());

	}

}
