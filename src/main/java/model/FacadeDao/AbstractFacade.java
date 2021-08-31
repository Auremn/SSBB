package model.FacadeDao;

import model.dao.DaoArme;
import model.dao.DaoFactory;

public class AbstractFacade<T> {
	DaoArme daoArme = DaoFactory.fabriquerDaoArme();
}
