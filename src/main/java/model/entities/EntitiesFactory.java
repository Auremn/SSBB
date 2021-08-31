package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.dao.ArmeJDBCDaoImpl;
import model.entities.references.Pouvoir;
import model.entities.references.TypeCombattant;
import outils.ValidatorUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntitiesFactory {
	private static final Log log = LogFactory.getLog(ArmeJDBCDaoImpl.class);

	
	public static Arme fabriquerArmeZampakuto(String idArme,String nomArme,String bankai,String typeArme,String description) {
		
		Arme na = null;
		try {
			na = new Arme(idArme, nomArme, bankai, typeArme, description);
			ValidatorUtils.validate(na);
			return na;
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return na;
		
	}

	
	public static Combattant fabriquerCombattantSansArme(String nom,String prenom, TypeCombattant tpCbt) {
			// TODO Rajouter les pouvoires dans le constructeur
			try {
				switch (tpCbt) {
				case HUMAIN:
					Humain hu = new Humain(UUID.randomUUID(), nom, prenom);
					ValidatorUtils.validate(hu);
					return hu;
				case HOLLOW:
					Hollow ho = new Hollow(UUID.randomUUID(),nom, prenom);
					List<Pouvoir> lstPouvoirHo = new ArrayList<>();
					lstPouvoirHo.add(Pouvoir.CERO);
					lstPouvoirHo.add(Pouvoir.MASQUE);
					lstPouvoirHo.add(Pouvoir.SONIDO);
					lstPouvoirHo.add(Pouvoir.REGENERATION);
					ho.setLstPouvoir(lstPouvoirHo);
					ValidatorUtils.validate(ho);
					return ho;
				case SHINIGAMI:
					Shinigami sh = new Shinigami(UUID.randomUUID(), nom, prenom);
					List<Pouvoir> lstPouvoirSh = new ArrayList<>();
					lstPouvoirSh.add(Pouvoir.KIDO);
					lstPouvoirSh.add(Pouvoir.HAKUDA);
					lstPouvoirSh.add(Pouvoir.HOHO);
					lstPouvoirSh.add(Pouvoir.ZANJETSU);
					sh.setLstPouvoir(lstPouvoirSh);
					ValidatorUtils.validate(sh);
					return sh;
	
				}
			} catch (Exception e) {
				log.error("ERREUR a la création du combattant");
			}
		return null;
	}
	
public static Combattant fabriquerCombattant(String nom,String prenom, TypeCombattant tpCbt, Arme arme, List<Pouvoir> pouvoirs  ) {
		
		try {
			switch (tpCbt) {
			
			case HUMAIN:
				Humain hu = new Humain(UUID.randomUUID(),nom, prenom, arme, pouvoirs);
				ValidatorUtils.validate(hu);
				return hu;
			case HOLLOW:
				Hollow ho = new Hollow(UUID.randomUUID(),nom, prenom, arme, pouvoirs);
				
				List<Pouvoir> lstPouvoirHo = new ArrayList<>();
				lstPouvoirHo.add(Pouvoir.CERO);
				lstPouvoirHo.add(Pouvoir.MASQUE);
				lstPouvoirHo.add(Pouvoir.SONIDO);
				lstPouvoirHo.add(Pouvoir.REGENERATION);
				ho.setLstPouvoir(lstPouvoirHo);
				ValidatorUtils.validate(ho);
				return ho;
			case SHINIGAMI:
				Shinigami sh = new Shinigami(UUID.randomUUID(),nom, prenom, arme, pouvoirs);
				List<Pouvoir> lstPouvoirSh = new ArrayList<>();
				lstPouvoirSh.add(Pouvoir.KIDO);
				lstPouvoirSh.add(Pouvoir.HAKUDA);
				lstPouvoirSh.add(Pouvoir.HOHO);
				lstPouvoirSh.add(Pouvoir.ZANJETSU);
				sh.setLstPouvoir(lstPouvoirSh);
				ValidatorUtils.validate(sh);
				return sh;
			}
		} catch (Exception e) {
			log.error("ERREUR a la création du combattant");
		}
		return null;
		
		

	}
	

	
	
}
