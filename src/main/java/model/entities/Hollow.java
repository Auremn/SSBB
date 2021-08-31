package model.entities;

import java.util.List;
import java.util.UUID;

import model.entities.references.Pouvoir;
import model.entities.references.TypeCombattant;

public class Hollow extends Combattant {

	
	public Hollow(UUID idCombattant, String nom,String prenom, Arme arme, List<Pouvoir> lstPouvoirs) {
		super(idCombattant,TypeCombattant.HOLLOW,nom,prenom,arme,lstPouvoirs);
	}
	
	public Hollow(UUID idCombattant, String nom,String prenom) {
		super(idCombattant,TypeCombattant.HOLLOW,nom,prenom);
	}


}
