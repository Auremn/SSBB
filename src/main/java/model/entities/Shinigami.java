package model.entities;

import java.util.List;
import java.util.UUID;

import model.entities.references.Pouvoir;
import model.entities.references.TypeCombattant;

public class Shinigami extends Combattant{
	
	public Shinigami(UUID idCombattant, String nom,String prenom, Arme arme, List<Pouvoir> lstPouvoirs) {
		super(idCombattant,TypeCombattant.SHINIGAMI,nom,prenom,arme,lstPouvoirs);
	}
	
	public Shinigami(UUID idCombattant, String nom,String prenom) {
		super(idCombattant,TypeCombattant.SHINIGAMI,nom,prenom);
	}
	
}
