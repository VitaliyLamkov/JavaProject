package ru.kalachteh.app.dao;
import java.util.Comparator;

public class ComparatorMaterialName implements Comparator<EntityMaterial> {

	@Override
	public int compare(EntityMaterial o1, EntityMaterial o2) {
		// TODO Auto-generated method stub
		//System.out.println(o1.getInvnumber());
//		if (o1.getInvnumber() == null && o2.getInvnumber() != null) return -1;
//		if (o1.getInvnumber() != null && o2.getInvnumber() == null) return 1;
//		if (o1.getInvnumber() == null && o2.getInvnumber() == null) return 0;
//		
		
		if (o1.getName() == null && o2.getName() != null) return -1;
		if (o1.getName() != null && o2.getName() == null) return 1;
		if (o1.getName() == null && o2.getName() == null) return 0;
		return o1.getName().compareTo(o2.getName());

//		return o1.getInvnumber().compareTo(o2.getInvnumber());

	}

}
