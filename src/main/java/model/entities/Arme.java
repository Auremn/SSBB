package model.entities;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.entities.references.C;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity

@Table(name = "ARME")
@NamedQueries({
	@NamedQuery(name = "ARME_BY_NOMARME", query = " SELECT a FROM Arme a WHERE a.nomArme = ?1 "),
	@NamedQuery(name = "ARME_READ_ALL", query = " SELECT a FROM Arme a")
	}
	)
@NoArgsConstructor(access = AccessLevel.PUBLIC)

public class Arme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3989262311979163710L;


	@Getter
	@Id
	String idArme = UUID.randomUUID().toString();
	
	
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	@Column(length = 25, nullable = false, unique = true)
	String nomArme;
	
	
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	String bankai;
	
	
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	@Column(length = 25, nullable = false, unique = true)
	String typeArme;
	
	
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	@Column(length = 25, nullable = false, unique = true)
	String description;


	public Arme(String idArme,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") String nomArme,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") String typeArme,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") String description) {
		super();
		this.idArme = idArme;
		this.nomArme = nomArme;
		this.typeArme = typeArme;
		this.description = description;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankai == null) ? 0 : bankai.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((nomArme == null) ? 0 : nomArme.hashCode());
		result = prime * result + ((typeArme == null) ? 0 : typeArme.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arme other = (Arme) obj;
		if (bankai == null) {
			if (other.bankai != null)
				return false;
		} else if (!bankai.equals(other.bankai))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nomArme == null) {
			if (other.nomArme != null)
				return false;
		} else if (!nomArme.equals(other.nomArme))
			return false;
		if (typeArme == null) {
			if (other.typeArme != null)
				return false;
		} else if (!typeArme.equals(other.typeArme))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Arme [ Type de l'arme: ");
		builder.append(typeArme);
		builder.append(", Nom de l'arme: ");
		builder.append(nomArme);
		if (typeArme.contains("Zampakuto")) {
			builder.append(", bankai: ");
			builder.append(bankai);
		}
		builder.append(", description: ");
		builder.append(description);
		builder.append(" ]");
		return builder.toString();
	}
	
	

	
	
}
