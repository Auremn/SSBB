package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import common.dao.Dao;

public abstract class AbstractDao<T,K> implements Dao<T,K> {
	
	private final static EntityManager EM = Persistence.createEntityManagerFactory("SUPER_SMASH_BLEACH_ULTIMATE_EMN_JPA_JFX").createEntityManager();

	
	protected EntityManager getEntityManager() {
		return EM;
	}
	
	

	
	
	
	
	
	


		

	
}
