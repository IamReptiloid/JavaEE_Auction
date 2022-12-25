package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.Auction;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.AuctionDAO;

import java.sql.Date;
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

    @Override
    public int getLastAuctionInsert() {
        String query = resourcer.getString("auction.get.last.insert");

        try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void createAuction(int idCreator, String name, String description, String status) {
        String query = resourcer.getString("auction.insert");
        try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
            statement.setInt(1, idCreator);
            statement.setString(2, description);
            statement.setString(3, name);
            statement.setString(4, status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Auction> getAuctionByUserId(int id) {
        String query = resourcer.getString("auction.get.auctions.by.user.id");
        List<Auction> auctionList = new ArrayList<>();

        try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
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

    @Override
    public void updateAuction(int id, String name, String description, String status) {
        String query = resourcer.getString("auction.update.by.id");
        try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
            statement.setString(1, description);
            statement.setString(2, name);
            statement.setString(3, status);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
