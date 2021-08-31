package model.facade;

import java.util.List;
import java.util.Optional;

import common.dao.exceptions.DaoException;
import model.dao.DaoArme;
import model.dao.DaoFactory;
import model.dao.references.C;
import model.entities.Arme;
import model.exceptions.BusinessException;

public final class FacadeMetierImpl implements FacadeMetier {

	private final DaoArme daoArme = DaoFactory.fabriquerDaoArme();
//	private final AbstractCombattantDaoImpl daoCombattant = DaoFactory.fabriquerCombattantJDBCDao();

	
	private static final FacadeMetierImpl facadeMetierImpl = new FacadeMetierImpl();

	
	private FacadeMetierImpl() {}
	
	public static FacadeMetierImpl getInstance() {
		return facadeMetierImpl;
	}
	
	@Override
	public void init() {
		daoArme.initialisationArme();
//		daoCombattant.init();
		
	}
	
//	@Override
//	public List<Combattant> recupererListeCombattant() throws BusinessException {
//		try {
//			return daoCombattant .readAll();
//		} catch (DaoException e) {
//			throw new BusinessException(C.RECUPERER_LISTE_LOCATION_EXCEPTION);
//		}
//	}
//
//	@Override
//	public void creerCombattant(Combattant combattant) throws BusinessException {
//		try {
//			daoCombattant.create(combattant);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			throw new BusinessException(e);
//		}
//
//	}
//
//	@Override
//	public void modifierCombattant(Combattant combattant) throws BusinessException {
//		try {
//			daoCombattant.update(combattant);
//		} catch (DaoException e) {
//			throw new BusinessException(e);
//		}
//
//	}
//
//	@Override
//	public void supprimerCombattant(Combattant combattant) throws BusinessException {
//		try {
//			daoCombattant.delete(combattant);
//		} catch (DaoException e) {
//			throw new BusinessException(e);
//		}
//
//	}
	
	
	@Override
	public Optional<List<Arme>> recupererArmes() throws BusinessException {
		try {
			return Optional.of(daoArme.readAll());
		}catch (DaoException e) {
			throw new BusinessException(String.format(C.RECUPERER_ARME_FAIL, e.getMessage()));
		}
	}
	


}
