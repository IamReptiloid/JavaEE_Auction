package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.database.dao.impl.AuctionDAOImpl;
import ru.rsreu.auction.database.dao.impl.RoleDaoImpl;
import ru.rsreu.auction.database.dao.impl.SessionDAOImpl;
import ru.rsreu.auction.database.dao.impl.UserDAOImpl;

public class DAOFactory {

	private DAOFactory() {};

	public static RoleDAO getRoleDao() {
		return RoleDaoImpl.getInstance();
	}

	public static UserDAO getUserDAO() {
		return UserDAOImpl.getInstance();
	}

	public static SessionDAO getSessionDAO() {
		return SessionDAOImpl.getInstance();
	}

    public static AuctionDAO getAuctionDAO() { return AuctionDAOImpl.getInstance(); }
}
