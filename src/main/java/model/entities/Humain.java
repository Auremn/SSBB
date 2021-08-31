package model.entities;

import java.util.List;
import java.util.UUID;

import model.entities.references.Pouvoir;
import model.entities.references.TypeCombattant;

public class Humain extends Combattant {

	public Humain(UUID idCombattant, String nom,String prenom, Arme arme, List<Pouvoir> lstPouvoirs) {
		super(idCombattant,TypeCombattant.HUMAIN,nom,prenom,arme,lstPouvoirs);
	}
	
	public Humain(UUID idCombattant, String nom,String prenom) {
		super(idCombattant,TypeCombattant.HUMAIN,nom,prenom);
	}
	
}
