package ru.rsreu.auction.service;

import ru.rsreu.auction.data.Auction;
import ru.rsreu.auction.database.dao.AuctionDAO;
import ru.rsreu.auction.database.dao.DAOFactory;

import java.util.List;
import java.util.Optional;

public class AuctionService {
    private static final AuctionDAO auctionDAO = DAOFactory.getAuctionDAO();

    public List<Auction> getAllAuctions() {
        return auctionDAO.getAllAuctions();
    }
    public List<Auction> getAuctionByUserId(Optional<Integer> id) {
        if(id.isPresent()) {
            return auctionDAO.getAuctionByUserId(id.get());
        } else {
            throw new RuntimeException();
        }
    }

    public void updateAuction(int id, String name, String description, String status) {
        auctionDAO.updateAuction(id, name, description, status);
    }
}
