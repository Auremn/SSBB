package model.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.dao.Dao;
import model.entities.Combattant;
import model.entities.EntitiesFactory;
import model.entities.references.TypeCombattant;

public class AbstractCombattantDaoImpl implements Dao<Combattant, UUID>{
	
	private static final Log log = LogFactory.getLog(AbstractCombattantDaoImpl.class);

	public void init() {
		log.info(CDao.INITIALISATION_COMBATTANT);
		try {
			InputStream is = AbstractCombattantDaoImpl.class.getResourceAsStream("/Combattant.txt");
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				while(reader.ready()) {
					String line = reader.readLine();
					String[] CbtData = line.split("\\|");
					
					String nom = CbtData[0];
					String prenom = CbtData[1];
					TypeCombattant typeCombattant = TypeCombattant.valueOf(CbtData[2]);
					
					// TODO Rajouter les pouvoires dans le constructeur
					Combattant cbt = EntitiesFactory.fabriquerCombattantSansArme(nom, prenom, typeCombattant);

					create(cbt);
				}
			}
			
		}catch(Exception e) {
			log.error("Une erreur s'est passÃ© lors de l'initialisation des armes");
		}
		
	}
	
}
