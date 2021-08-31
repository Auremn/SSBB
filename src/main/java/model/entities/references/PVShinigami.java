package model.entities.references;

public enum PVShinigami {

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
	private PVShinigami(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
