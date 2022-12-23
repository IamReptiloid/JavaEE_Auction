package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.Lot;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.LotDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LotDAOImpl implements LotDAO {
	private static volatile LotDAOImpl instance;
	private final Resourcer resourcer;

	private LotDAOImpl() {
		resourcer = ProjectResourcer.getInstance();
	}

	@Override
	public List<Lot> getLotsByAuctionId(int id) {
		List<Lot> result = new ArrayList<>();
		String query = resourcer.getString("lot.get.by.auction.id");
		try(PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(
						new Lot(
								resultSet.getLong("id"),
								resultSet.getInt("price"),
								resultSet.getTimestamp("closing_date"),
								resultSet.getString("description"),
								resultSet.getString("path_to_picture"),
								resultSet.getInt("step"),
								resultSet.getString("status"),
								resultSet.getString("name"),
								resultSet.getString("winner")

						)
				);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static LotDAOImpl getInstance() {
		synchronized (LotDAOImpl.class) {
			if (instance == null) {
				instance = new LotDAOImpl();
			}
		}

		return instance;
	}
}
