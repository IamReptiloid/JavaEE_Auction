package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.database.dao.impl.*;

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

	public static LotDAO getLotDAO() {return LotDAOImpl.getInstance(); }
}
