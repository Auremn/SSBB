package model.entities.references;

public enum Pouvoir {

	MASQUE("Masque de hollow conférant a son utilisateur des pouvoirs d'hollows."),
	CERO("Puissante exploision de Reatsu dans la puissance, la force et la vitesse depend de la puissance de l'utilisateur"),
	SONIDO("Maitrise de la vitesse"),
	REGENERATION("Regeneration ultra-rapide"),
	
	KIDO("Sort r�alis� par les Shinigami, et dont l'execution d�pend essentielement de la maitrise des flux de Reiatsu"),
	HAKUDA("Technique de Combat a main Nues"),
	HOHO("Maitrise de la vitesse"),
	ZANJETSU("Maitrise du sabre");
	
	private String libelle;

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 */
	private Pouvoir(String libelle) {
		this.libelle = libelle;
	}
	
	
}
