package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.Auction;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.AuctionDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDAOImpl implements AuctionDAO {
    private static volatile AuctionDAOImpl instance;
    private final Resourcer resourcer;

    private AuctionDAOImpl() {
        resourcer = ProjectResourcer.getInstance();
    }

    public static AuctionDAOImpl getInstance() {
        if (instance == null){
            synchronized (AuctionDAOImpl.class) {
                if (instance == null) {
                    instance = new AuctionDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Auction> getAllAuctions() {
        String query = resourcer.getString("auction.get.all.auctions");
        List<Auction> auctionList = new ArrayList<>();

        try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                auctionList.add(new Auction(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_creator"),
                        resultSet.getString("description"),
                        resultSet.getString("name"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auctionList;
    }
}
