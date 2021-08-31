package view.facade;

import java.util.List;

import model.entities.Arme;
import model.entities.Combattant;
import model.exceptions.ChoixInvalideException;
import model.exceptions.CombattantException;
import model.exceptions.ModificationClientExcpetion;
import model.exceptions.SaisirCombattantException;


public interface FacadeVue {

	/**
	 * Affiche un message pass� en param�tre.
	 * @param msg message.
	 */
	public void afficherMessage(String msg);

	/**
	 * Affiche le menu principal de l'application.
	 * @return le num�ro de l'option choisie par l'utilisateur.
	 */
//	public int afficherMenu();

	/**
	 * Affiche un menu pass� en param�tre.
	 * @param menu menu.
	 * @param nomMenu Titre du menu.
	 * @return le num�ro de l'option choisie par l'utilisateur.
	 */
	public int afficherMenu(String[] menu, String nomMenu);

	/**
	 * Affiche la liste des Combattants.
	 * @param lstCombattants liste des Combattants.
	 * 
	 * 
	 * <p>Liste des Combattants (3)
	 * <p>Dupuis               ofon                  (nb loc :  2)  permis :  valide jusqu'au : 01/01/2030 [B][C]
	 * <p>Dupuis               ofond                 (nb loc :  1)  permis :  valide jusqu'au : 01/12/2019 [B]
	 * <p>Aymar                jean                  (nb loc :  1)  permis :  valide jusqu'au : 01/01/2040 [A][C]
	 * 
	 */
	public void afficherListeCombattants(List<Combattant> lstCombattant);

	/**
	 * Propose la saisie des informations d'un Combattant.
	 * @return le Combattant saisi.
	 * @throws SaisirCombattantException l�ve une exception.
	 */
	public Combattant saisirCombattant() throws SaisirCombattantException;

	/**
	 * Propose la modification des informations d'un Combattant.
	 * @param lstCombattants liste des Combattants de l'application.
	 * @return le Combattant modifi�.
	 * @throws ModificationCombattantExcpetion l�ve une exception.
	 * @throws ChoixInvalideException l�ve une exception.
	 * @throws ModificationClientExcpetion 
	 * @throws CombattantException l�ve une exception.
	 */
	public Combattant modifierCombattant(List<Combattant> lstCombattant) throws ChoixInvalideException, ModificationClientExcpetion;

	/**
	 * Affiche la fiche d'un Combattant.
	 * @param lstCombattants liste des Combattants.
	 * @throws ChoixInvalideException l�ve une exception.
	 */
//	public void afficherFicheCombattant(List<Combattant> lstCombattant);

	/**
	 * Propose la s�lection d'un Combattant parmis la liste des Combattants de l'application.
	 * @param lstCombattants liste des Combattants de l'application.
	 * @return le Combattant s�lectionn�.
	 * @throws ChoixInvalideException  l�ve une exception.
	 */
	public Combattant selectionnerCombattant(List<Combattant> lstCombattant) throws ChoixInvalideException;

	public String[] retournerUnTableauPropertiesFR(String t);

	public String[] retournerUnTableauPropertiesEN(String t);

	public Arme selectionnerArme(final List<Arme> listeArme,String msg);
	
	public List<String> transformerStringLstElementsEnum(Arme[] tabArmeEnum);

	void afficherArme(Arme arme);

}
