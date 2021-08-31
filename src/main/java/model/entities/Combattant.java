package model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.entities.references.C;
import model.entities.references.Pouvoir;
import model.entities.references.TypeCombattant;
import model.exceptions.CombattantException;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(exclude =  {"idCombattant"})
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Combattant {
	
	@NonNull
	@Getter
	UUID idCombattant  = UUID.randomUUID();
	
	@NonNull	
	@Getter
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	TypeCombattant TypeCbt;
	
	@NonNull	
	@Getter
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	String nom;

	@NonNull
	@Getter
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	String prenom;
	
	
	@Getter
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	@NotEmpty(message = C.ENTITE_EMPTY_EXCEPTION)
	Arme na;
	
	@NonNull	
	@Setter
	@NotNull(message = C.ENTITE_NULL_EXCEPTION)
	List<Pouvoir> lstPouvoir = new ArrayList<>();
	
	/**
	 * @return lstPouvoir
	 */
	public List<Pouvoir> getLstPouvoir() {
		return Collections.unmodifiableList(this.lstPouvoir);
	}

	public void ajouterPouvoir(Pouvoir pouvoir) throws CombattantException {
		if (Objects.isNull(pouvoir) || this.lstPouvoir.contains(pouvoir)) {
			throw new CombattantException(C.COMBATTANT_AJOUT_POUVOIR_EXCEPTION);
		}
		this.lstPouvoir.add(pouvoir);
	}

	public Combattant(UUID idCombattant,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") TypeCombattant typeCbt,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") String nom,
			@NotNull(message = "ERREUR: Le champ ne peut etre null") @NotEmpty(message = "ERREUR: Le champ ne peut etre vide") String prenom) {
		super();
		this.idCombattant = idCombattant;
		TypeCbt = typeCbt;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Combattant [Type du Combattant: ");
		builder.append(TypeCbt);
		builder.append(", nom du Combattant: ");
		builder.append(nom);
		builder.append(", prenom du combattant: ");
		builder.append(prenom);
		builder.append(", Arme utilisé: ");
		builder.append(na);
		builder.append(", liste des pouvoires: ");
		builder.append(lstPouvoir);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
}
