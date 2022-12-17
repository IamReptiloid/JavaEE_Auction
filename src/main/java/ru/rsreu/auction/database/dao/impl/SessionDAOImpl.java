package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.Session;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.SessionDAO;
import ru.rsreu.auction.enums.RoleType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SessionDAOImpl implements SessionDAO {
	private Resourcer resourcer;
	private static volatile SessionDAOImpl sessionDaoImpl;

	public SessionDAOImpl() {
		resourcer = ProjectResourcer.getInstance();
	}

	public static SessionDAO getInstance() {
		synchronized (SessionDAOImpl.class) {
			if(sessionDaoImpl == null) {
				sessionDaoImpl = new SessionDAOImpl();
			}
		}
		return sessionDaoImpl;
	}

	@Override
	public void save(Session session) {
		String query = resourcer.getString("session.save");
		try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			System.out.println(new Date(session.getExpiredAt().getTime()));
			statement.setInt(2, session.getUser().getId().intValue());
			statement.setDate(1, new Date(session.getExpiredAt().getTime()));

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Session> findByUserId(int id) {
		String query = resourcer.getString("session.find.by.user.id");
		try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while(result.next()) {
				return Optional.of(new Session(
						result.getTimestamp("expired_at"),
						new User(
								result.getInt("user_id"),
								result.getString("USERNAME"),
								result.getString("PASSWORD"),
								result.getString("NAME"),
								result.getInt("IS_BLOCKED"),
								RoleType.valueOf(result.getString("role").toUpperCase())
						)
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
