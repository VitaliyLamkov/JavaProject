package ru.kalachteh.app.dao;

import java.util.Comparator;

public class ComparatorMaterialInvnumber implements Comparator<EntityMaterial> {
	@Override
	public int compare(EntityMaterial o1, EntityMaterial o2) {
		// TODO Auto-generated method stub
		if (o1.getInvnumber() == null && o2.getInvnumber() != null) return -1;
		if (o1.getInvnumber() != null && o2.getInvnumber() == null) return 1;
		if (o1.getInvnumber() == null && o2.getInvnumber() == null) return 0;
		
		return o1.getInvnumber().compareTo(o2.getInvnumber());

	}

}
