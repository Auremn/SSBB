package model.dao;

public class Requests {

	public static final String INSERT_ARME = "INSERT INTO arme(idArme,nomArme,bankai,typeArme,description) VALUES (?, ?, ?, ?, ?);";
	public static final String SELECT_ARME_ALL = "SELECT idArme FROM arme";
	public static final String SELECT_FILM_BY_ID = "SELECT * FROM arme";
	public static final String READ_ARME_BY_ID = "SELECT * FROM arme WHERE idArme = ?";
	public static final String READ_ARME_BY_NOM = "SELECT * FROM arme WHERE nom=?;";

}
