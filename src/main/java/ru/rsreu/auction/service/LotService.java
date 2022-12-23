package ru.rsreu.auction.service;

import ru.rsreu.auction.data.Lot;
import ru.rsreu.auction.database.dao.DAOFactory;
import ru.rsreu.auction.database.dao.LotDAO;

import java.util.List;

public class LotService {
	private LotDAO lotDAO = DAOFactory.getLotDAO();

	public List<Lot> getLotsByAuctionId(int id) {
		return lotDAO.getLotsByAuctionId(id);
	}
}
