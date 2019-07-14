package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorGruppaName implements Comparator<EntityGruppa>{
	@Override
	public int compare(EntityGruppa o1, EntityGruppa o2) {
		if (o1.getName() == null && o2.getName() != null) return -1;
		if (o1.getName() != null && o2.getName() == null) return 1;
		if (o1.getName() == null && o2.getName() == null) return 0;
		return o1.getName().compareTo(o2.getName());


	}

}
