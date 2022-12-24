package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.data.Auction;

import java.util.List;

public interface AuctionDAO {
    List<Auction> getAllAuctions();
    List<Auction> getAuctionByUserId(int id);
    void updateAuction(int id, String name, String description, String status);
}
