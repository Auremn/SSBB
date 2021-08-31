package view.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import common.view.util.AffichageConsole;
import common.view.util.LectureConsole;
import model.entities.Arme;
import model.entities.Combattant;
import model.entities.EntitiesFactory;
import model.entities.comparator.CombattantNomprenomComparator;
import model.entities.references.TypeCombattant;
import model.exceptions.ChoixInvalideException;
import model.exceptions.ModificationClientExcpetion;
import model.exceptions.SaisirCombattantException;
import outils.I18n;
import view.references.C;

public final class FacadeVueimpl implements FacadeVue {

	@Override
	public void afficherMessage(String msg) {
		AffichageConsole.afficherMessageAvecSautLigne(msg);
		
	}

	@Override
	public String[] retournerUnTableauPropertiesFR(String t) {
		I18n.changeLocal(Locale.FRENCH);
		String[] tabMenu = I18n.getTableau(t);
		return tabMenu;
	}
	
	@Override
	public String[] retournerUnTableauPropertiesEN(String t) {
		I18n.changeLocal(Locale.ENGLISH);
		String[] tabMenu = I18n.getTableau(t);
		return tabMenu;
	}

	@Override
	public int afficherMenu(String[] menu, String nomMenu) {
		AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(menu), nomMenu);

		return LectureConsole.lectureChoixInt(0, menu.length);
	}

	@Override
	public void afficherListeCombattants(List<Combattant> lstCombattant) {
		List<Combattant> listeCombattantTriee = new ArrayList<Combattant>(lstCombattant);
		
		Collections.sort(listeCombattantTriee,new CombattantNomprenomComparator() );;
		for (Combattant combattant : listeCombattantTriee) {
			AffichageConsole.afficherMessageAvecSautLigne(combattant.toString());
		}
	}

	@Override
	public Combattant saisirCombattant() throws SaisirCombattantException {
		I18n.changeLocal(Locale.FRENCH);
//		System.out.println(I18n.get("Bonjour"));
		String nom = LectureConsole.lectureChaineCaracteres(I18n.get("SAISIR_NOM_COMBATTANT"));
//		String nom = LectureConsole.lectureChaineCaracteres(C.SAISIR_NOM_COMBATTANT);
		String prenom = LectureConsole.lectureChaineCaracteres(C.SAISIR_PRENOM_COMBATTANT);

		TypeCombattant tpc=TypeCombattant.SHINIGAMI;
		
		//Lister Sp�cialit�s
		AffichageConsole.afficherMenuEntoureAvecOptionSortie( listerType(), C.SAISIR_TYPE_COMBATTANT);	
		//Choisir Sp�cialit�
		
		int choixType = LectureConsole.lectureChoixInt(0, listerType().size());
		if (choixType !=0) {
		tpc = TypeCombattant.valueOf(listerType().get(choixType-1));
		}
		Combattant c;
		
			try {
				
				c= EntitiesFactory.fabriquerCombattantSansArme(nom, prenom, tpc);
			} catch (Exception e) {
				throw new SaisirCombattantException(C.SAISIR_COMBATTANT_EXCEPTION);
			}
		
		
		return c;
	}
	
	
	private static List<String> listerType() {
		List<String> listType = new ArrayList<>();
		for(TypeCombattant tpc : TypeCombattant.values()) {
			listType.add(tpc.toString());
		}
		return listType;
		
		
	}

	@Override
	public Combattant modifierCombattant(List<Combattant> lstCombattant) throws ChoixInvalideException, ModificationClientExcpetion {
		Combattant c = selectionnerCombattant(lstCombattant);
		return selectionnerChampsCombattantModification(c);
	}

	private Combattant selectionnerChampsCombattantModification(Combattant c) throws ModificationClientExcpetion {
		List<String> lst = new ArrayList<>();
		lst.add("nom");
		lst.add("pr�nom");
		AffichageConsole.afficherMenuSimple(lst);
		int choix = LectureConsole.lectureChoixInt(1, lst.size());

		return traiterChoixChampsClientModification(c,choix);
	}

	private Combattant traiterChoixChampsClientModification(Combattant c, int choix) throws ModificationClientExcpetion {
		switch (choix) {
		case 1:
			modifierNomCombattant(c);
			break;
		case 2:
			modifierPrenomCombattant(c);
			break;
			
		default:
			break;
		}
		return c;
	}

	private void modifierPrenomCombattant(Combattant c) {
		AffichageConsole.afficherMessageAvecSautLigne(String.format(C.COMBATTANT_PRENOM_ACTUEL, c.getPrenom()));
		String prenom = LectureConsole.lectureChaineCaracteres(C.SAISIR_PRENOM_COMBATTANT);
		c.setPrenom(prenom);
	}

	private void modifierNomCombattant(Combattant c) {
		AffichageConsole.afficherMessageAvecSautLigne(String.format(C.COMBATTANT_NOM_ACTUEL, c.getNom()));
		String nom = LectureConsole.lectureChaineCaracteres(C.SAISIR_NOM_COMBATTANT);
		c.setNom(nom);
	}

	@Override
	public Combattant selectionnerCombattant(List<Combattant> lstCombattant) throws ChoixInvalideException {
		List<Combattant> lstCombattantSorted = new ArrayList<>(lstCombattant);
		Collections.sort(lstCombattantSorted, new CombattantNomprenomComparator());
		AffichageConsole.afficherMenuSimpleAvecOptionSortie(listerCombattantSimple(lstCombattantSorted),"Retour");
		int choix = LectureConsole.lectureChoixInt(0, lstCombattantSorted.size());

		try {
			return lstCombattantSorted.get(choix-1);
		} catch (Exception e) {
			throw new ChoixInvalideException();
		}
	}
	
	private List<String> listerCombattantSimple(List<Combattant> lstCombattants) {
		List<String> lst = new ArrayList<>();
		for (Combattant combattant : lstCombattants) {
			lst.add(String.format("%s %s", combattant.getNom(), combattant.getPrenom()));
		}
		return lst;
	}
	
	public List<Arme> ajouterArmeToCombattant() {
		
		return null;
	}
	
	/**
	 * Méthode retournant un élément d'une Enum choisie par l'utilisateur.
	 */
	public <T> T demanderElementEnum(T[] tabElementsEnum, String msg) {
		int choix = afficherMenu(transformerStringLstElementsEnum(tabElementsEnum), msg);
		T element = null;
		if(choix !=0) {
			element = tabElementsEnum[choix-1];
		}
		return element;
	}
	
	/**
	 * Méthode transformant les libellés d'une énum en une liste de String.
	 * @param <T>
	 * @return listeCatVehi:String
	 */
	private static <T> List<String> transformerStringLstElementsEnum(T[] tabElementsEnum) {
		List<String> listeElementEnum = new ArrayList<>();
		for(T element : tabElementsEnum) {
			listeElementEnum.add(element.toString());
		}
		return listeElementEnum;
	}
	
	private int afficherMenu(List<String> transformerStringLstElementsEnum, String msg) {
		AffichageConsole.afficherMenuEntoureAvecOptionSortie(transformerStringLstElementsEnum, msg);
		return LectureConsole.lectureChoixInt(0, transformerStringLstElementsEnum.size());
	}
	
//	/**
//	* Méthode permettant de sélectionner un objet parmis une liste d'objets.
//	*@return objetChoisie:Objet
//	*/
//	public Arme selectionnerArme(final List<Arme> listeArme, String msg) {
//		// Converti listeObjets en listeString
//		List<String> listeStringArme = new ArrayList<>();
////		Arme[] tabArmeEnum = null;
//		for (Arme arm : listeArme) {
//			listeStringArme.add(arm.toString());
//		}
//		// Demande choix d'Objet à l'utilisateur
//		AffichageConsole.afficherMessageAvecSautLigne(msg);
//		AffichageConsole.afficherMenuSimple(transformerStringLstElementsEnum(Zampakuto.values()));
//		int choix = LectureConsole.lectureChoixInt(1, listeStringArme.size());
//		// Renvoie l'objet choisie
//		return listeArme.get(choix-1);
//	}
	
	/**
	 * Méthode transformant les libellés d'une énum en une liste de String.
	 * @param <T>
	 * @return listeCatVehi:String
	 */
	public List<String> transformerStringLstElementsEnum(Arme[] tabArmeEnum) {
		List<String> listeElementEnum = new ArrayList<>();
		for(Arme arme : tabArmeEnum) {
			listeElementEnum.add(arme.toString());
		}
		return listeElementEnum;
	}
	
	@Override
	public void afficherArme(Arme arme) {
		System.out.println(arme.toString());
	}

	@Override
	public Arme selectionnerArme(List<Arme> listeArme, String msg) {
		// TODO Auto-generated method stub
		return null;
	}
}
