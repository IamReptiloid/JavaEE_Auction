package ru.rsreu.auction.service;

import ru.rsreu.auction.data.Auction;
import ru.rsreu.auction.database.dao.AuctionDAO;
import ru.rsreu.auction.database.dao.DAOFactory;

import java.util.List;

public class AuctionService {
    private static final AuctionDAO auctionDAO = DAOFactory.getAuctionDAO();

    public static List<Auction> getAllAuctions() {
        return auctionDAO.getAllAuctions();
    }
}
