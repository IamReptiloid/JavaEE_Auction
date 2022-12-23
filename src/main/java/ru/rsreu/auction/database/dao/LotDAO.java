package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.data.Lot;

import java.util.List;

public interface LotDAO {
	List<Lot> getLotsByAuctionId(int id);
}
