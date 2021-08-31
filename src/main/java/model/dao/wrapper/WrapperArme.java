package model.dao.wrapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entities.Arme;
import model.entities.EntitiesFactory;

public class WrapperArme {

	public static Optional<List<Arme>> toListArme(ResultSet rs) throws SQLException {
		List<Arme> lstArme = new ArrayList<>();
		while (rs.next()) {
			String idArme = rs.getString("idArme");
			String nomArme = rs.getString("nomArme");
			String bankai = rs.getString("bankai");
			String typeArme = rs.getString("typeArme");
			String description = rs.getString("description");
			
			Arme arme = EntitiesFactory.fabriquerArmeZampakuto(idArme, nomArme, bankai, typeArme, description);
			lstArme.add(arme);
		}
		return Optional.ofNullable(lstArme);
	}

	public static void setPersonnage(PreparedStatement ps, Arme a) throws SQLException {
		ps.setString(1, a.getIdArme().toString());
		ps.setString(2, a.getNomArme());
		ps.setString(3, a.getBankai());
		ps.setString(4, a.getTypeArme());
		ps.setString(5, a.getDescription());
		ps.executeUpdate();
		
	}

	public static Optional<Arme> toArme(ResultSet rs) throws SQLException {
		Arme arme = null;
		if(rs.first()) {
			String idArme = rs.getString("idArme");
			String nomArme = rs.getString("nomArme");
			String bankai = rs.getString("bankai");
			String typeArme = rs.getString("typeArme");
			String description = rs.getString("description");
			
			arme = EntitiesFactory.fabriquerArmeZampakuto(idArme, nomArme, bankai, typeArme, description);
		}
		return Optional.ofNullable(arme);
	}

	

}
