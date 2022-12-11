package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.database.dao.impl.RoleDaoImpl;
import ru.rsreu.auction.database.dao.impl.UserDAOImpl;

public class DAOFactory {

	private DAOFactory() {};

	public static RoleDAO getRoleDao() {
		return RoleDaoImpl.getInstance();
	}

	public static UserDAO getUserDAO() {
		return UserDAOImpl.getInstance();
	}
}
