package ru.kalachteh.app.control.web;

import java.util.Comparator;

public class ComparatorPostName implements Comparator<EntityPost> {

	@Override
	public int compare(EntityPost o1, EntityPost o2) {
		if (o1.getName() == null && o2.getName() != null) return -1;
		if (o1.getName() != null && o2.getName() == null) return 1;
		if (o1.getName() == null && o2.getName() == null) return 0;
		return o1.getName().compareTo(o2.getName());

	}

}
