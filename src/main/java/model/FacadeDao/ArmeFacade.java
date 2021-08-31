package model.FacadeDao;

import java.util.Collection;

import common.dao.exceptions.DaoException;
import model.dao.DaoArme;
import model.dao.DaoFactory;
import model.entities.Arme;
import model.exceptions.BusinessException;

public class ArmeFacade extends AbstractFacade<Arme> {

	DaoArme daoArme = DaoFactory.fabriquerDaoArme();


//	public Arme searchArmeByNomPrenom(String nom, String prenom) {
//		Arme c = null;
//		try {
//			TypedQuery<Arme> query = getEntityManager()
////					.createQuery(" SELECT c FROM Arme c WHERE c.nom = ?1 AND c.prenom = ?2 ", Arme.class);
//			.createNamedQuery("Arme_BY_NOM_PRENOM",Arme.class);
//			query.setParameter(1, nom);
//			query.setParameter(2, prenom);
//			c = query.getSingleResult();
//		} catch (NoResultException e) {
//			c = null;
//		}
//		return c;
//	}



	public void initialisationArme() {
		this.daoArme.initialisationArme();
	}


	public Collection<Arme> readAll() throws BusinessException {
		try {
			return this.daoArme.readAll();
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
	}


	public void update(Arme ArmeAModifier) throws BusinessException {
		try {
			this.daoArme.update(ArmeAModifier);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}


	public void create(Arme ArmeAModifier) throws BusinessException {
		try {
			this.daoArme.create(ArmeAModifier);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}


	public void delete(Arme c) throws BusinessException {
		try {
			this.daoArme.delete(c);
		} catch (DaoException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}


	public Arme searchArmeByNomPrenom(String nomArme) {
		return this.daoArme.rechercherArmeNom(nomArme);
	}





	
	
}
