package model.entities.comparator;

import java.util.Comparator;

import model.entities.Combattant;

public class CombattantNomprenomComparator implements Comparator<Combattant> {




	@Override
	public int compare(Combattant o1, Combattant o2) {
		int retour = o1.getNom().compareTo(o2.getNom());
		
//		if (retour==0) {
//			retour = o1.getPrenom().compareTo(o2.getPrenom());
//		}
		
		return retour;
	}

}
