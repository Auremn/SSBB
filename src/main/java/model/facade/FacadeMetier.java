package model.facade;

import java.util.List;
import java.util.Optional;

import model.entities.Arme;
import model.exceptions.BusinessException;

public interface FacadeMetier {

	void init();
	
//	public List<Combattant> recupererListeCombattant() throws BusinessException;
//	public void creerCombattant(Combattant combattant) throws BusinessException;
//	public void modifierCombattant(Combattant combattant) throws BusinessException;
//	public void supprimerCombattant(Combattant combattant) throws BusinessException;

	public Optional<List<Arme>> recupererArmes() throws BusinessException;

	
}
