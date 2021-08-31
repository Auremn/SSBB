package Presenter;

import java.util.List;
import java.util.Optional;

import Utils.Exceptions.StringManagerException;
import model.entities.Arme;
import model.exceptions.BusinessException;
import model.facade.FacadeMetier;
import model.facade.FacadeMetierFactory;
import view.facade.FacadeVue;
import view.facade.FacadeVueFactory;
import view.references.C;

public class Presenter {
	
	private FacadeMetier metier = FacadeMetierFactory.fabriquerFacadeMetier();
	private FacadeVue vue = FacadeVueFactory.fabriquerFacadeVue();
	
	public Presenter( FacadeMetier metier,  FacadeVue vue) {
		this.metier = metier;
		this.vue = vue;
	}

	/**
	 * Execute l'application.
	 * @throws BusinessException 
	 * @throws StringManagerException 
	 */
	public void executer() throws StringManagerException, BusinessException {
		metier.init();
		int choix=0;
		do {
			choix = vue.afficherMenu(vue.retournerUnTableauPropertiesFR("MENU_PRINCIPAL"), C.TITRE_MENU_PRINCIPAL);
			traiterChoix(choix);			
		} while (choix != 0);
		
	}

	private void traiterChoix(int choix) throws StringManagerException, BusinessException {
		switch (choix) {
		case 1:
			creationCombattant();
			break;
			
		case 2:
			listerCombattant();
			break;	
		
		case 3:
			modifierCombattant();
			break;
		case 4:
			suppressionCombattant();
			break;
		case 5:
			afficherArme();
			break;

		default:
			break;
		}	
	
	
	
	
}

	private void suppressionCombattant() {
//		try {
//			metier.supprimerCombattant(vue.selectionnerCombattant(metier.recupererListeCombattant()));
//		} catch (BusinessException e) {
//			this.vue.afficherMessage(e.getMessage());
//		} catch (ChoixInvalideException e) {
//			this.vue.afficherMessage(e.getMessage());
//		}
		vue.afficherMessage("Mise a jour du projet en cours, code en commentaire, veillez contacter l'admin.");
		
	}

	private void modifierCombattant() {
//		try {
//			metier.modifierCombattant(vue.modifierCombattant(metier.recupererListeCombattant()));
//		} catch (BusinessException | ChoixInvalideException | ModificationClientExcpetion e) {
//			
//			this.vue.afficherMessage(e.getMessage());
//		}
		vue.afficherMessage("Mise a jour du projet en cours, code en commentaire, veillez contacter l'admin.");
	}

	private void listerCombattant() {
//		try {
//			vue.afficherListeCombattants(metier.recupererListeCombattant());
//		} catch (BusinessException e) {
//			this.vue.afficherMessage(e.getMessage());
//		}
		vue.afficherMessage("Mise a jour du projet en cours, code en commentaire, veillez contacter l'admin.");
	}


	private void creationCombattant() {
//		try {
//			metier.creerCombattant(vue.saisirCombattant());
//		} catch (BusinessException | SaisirCombattantException e) {
//			vue.afficherMessage(e.getMessage());
//		}
		vue.afficherMessage("Mise a jour du projet en cours, code en commentaire, veillez contacter l'admin.");
	
	}
	
	public void afficherArme() throws StringManagerException, BusinessException {
		Optional<List<Arme>> oArme = metier.recupererArmes();
		if(oArme.isPresent()) {
			for (Arme na : oArme.get()) {
				vue.afficherArme(na);
			}
		} else {
			System.out.println("Aucune arme n'existe");
		}
	}
		
}
