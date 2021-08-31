package model.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.dao.exceptions.DaoException;
import model.entities.Arme;
import model.entities.EntitiesFactory;

public class ArmeJDBCDaoImpl extends AbstractDao<Arme, String> implements DaoArme{
	private static final Log log = LogFactory.getLog(ArmeJDBCDaoImpl.class);
//	private final static Connection cnx = BDDUtils.getConnection(ArmeJDBCDaoImpl.class.getResourceAsStream("/bdd.properties")).get();
//	private final static Connection CNX = Connect.to( "bdd.properties" );

	
	
	public void create(Arme a) throws DaoException {
		
		if (!exist(a)) {
			EntityTransaction trans = getEntityManager().getTransaction();
			trans.begin();
			getEntityManager().persist(a);
			trans.commit();
		}
		
	}

	@Override
	public void update(Arme a) throws DaoException {
		EntityTransaction trans = getEntityManager().getTransaction();
		trans.begin();
		getEntityManager().merge(a);
		trans.commit();
	}
	
	@Override
	public void delete(Arme a) throws DaoException {
		EntityTransaction trans = getEntityManager().getTransaction();
		trans.begin();
		getEntityManager().remove(a);
		trans.commit();
	}
	

	public List<Arme> readAll() throws DaoException {
		List<Arme> lst = null;
		try {
			
			TypedQuery<Arme> query = getEntityManager().createNamedQuery("ARME_READ_ALL",Arme.class);
			lst = query.getResultList();
		} catch (NoResultException e) {
			lst = new ArrayList<>();
		}
		return lst;
		
	}
	
	@Override
	public Arme rechercherArmeNom(String nomArme) {
		Arme c = null;
		try {
			TypedQuery<Arme> query = this.getEntityManager()
//					.createQuery(" SELECT c FROM Arme c WHERE c.nom = ?1 AND c.prenom = ?2 ", Arme.class);
			.createNamedQuery("ARME_BY_NOMARME",Arme.class);
			query.setParameter(1, nomArme);
			c = query.getSingleResult();
		} catch (NoResultException e) {
			c = null;
		}
		return c;
	}

	@Override
	public void initialisationArme() {
		log.info(CDao.INITIALISATION_ARME);
		try {
			InputStream is = ArmeJDBCDaoImpl.class.getResourceAsStream("/arme.txt");
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				while(reader.ready()) {
					String line = reader.readLine();
					String[] ArmeData = line.split("\\|");
					
					String nomArme = ArmeData[0];
					String bankai = ArmeData[1];
					String typeArme = ArmeData[2];
					String description = ArmeData[3];
					
					Arme arme = EntitiesFactory.fabriquerArmeZampakuto(UUID.randomUUID().toString(), nomArme, bankai, typeArme, description);
//					System.out.println(arme.toString());
					
					create(arme);
				}
			}
			
		}catch(Exception e) {
			log.error("Une erreur s'est passÃ© lors de l'initialisation des armes");
		}
		
		
	}

	public boolean exist(Arme a) throws DaoException {
		boolean exist = false;
		for (Arme ar : readAll()) {
			exist = ar.equals(a);
			if(exist){
				return true;
			}
		}
		return false;
	}

}
