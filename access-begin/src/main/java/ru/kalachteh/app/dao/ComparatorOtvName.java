package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorOtvName implements Comparator<EntityOtv> {
	@Override
	public int compare(EntityOtv o1, EntityOtv o2) {
		if (o1.getSurname()+" "+o1.getName()+" "+o1.getPatronymic() == null 
				 && o2.getSurname()+" "+o2.getName()+" "+o2.getPatronymic()  != null) return -1;
		if (o1.getSurname()+" "+o1.getName()+" "+o1.getPatronymic() != null 
				&& o2.getSurname()+" "+o2.getName()+" "+o2.getPatronymic() == null) return 1;
		if (o1.getSurname()+" "+o1.getName()+" "+o1.getPatronymic() == null 
				&& o2.getSurname()+" "+o2.getName()+" "+o2.getPatronymic() == null) return 0;
		return (o1.getSurname()+" "+o1.getName()+" "+o1.getPatronymic()).compareTo(o2.getSurname()+" "+o2.getName()+" "+o2.getPatronymic());
		
	}

}
