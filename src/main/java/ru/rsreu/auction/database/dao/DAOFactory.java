package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.database.dao.impl.RoleDaoImpl;

public class DAOFactory {

	private DAOFactory() {};

	public static RoleDAO getRoleDao() {
		return RoleDaoImpl.getInstance();
	}
}
