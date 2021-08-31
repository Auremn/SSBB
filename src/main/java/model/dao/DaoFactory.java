package model.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaoFactory {	
	
	public static DaoArme fabriquerDaoArme() {
		return new ArmeJDBCDaoImpl();
	}

//	public static AbstractCombattantDaoImpl fabriquerCombattantJDBCDao() {
//		return new CombattantJDBCDaoImpl();
//	}
	
}
