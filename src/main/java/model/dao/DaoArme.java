package model.dao;

import common.dao.Dao;
import model.entities.Arme;

public interface DaoArme extends Dao<Arme, String> {

	public void initialisationArme();
	
	
	public Arme rechercherArmeNom(String nomArme);
	
}
