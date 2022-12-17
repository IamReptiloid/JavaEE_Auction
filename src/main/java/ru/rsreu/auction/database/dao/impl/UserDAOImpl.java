package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.UserDAO;
import ru.rsreu.auction.enums.RoleType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
	private static volatile UserDAOImpl instance;
	private Resourcer resourcer;
	public UserDAOImpl() {
		resourcer = ProjectResourcer.getInstance();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return null;
	}

	@Override
	public Optional<User>  gerUserByLogin(String login) {
		String query = resourcer.getString("user.query.find.by.login");
		try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				User user = new User(
						resultSet.getInt("id"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getString("name"),
						resultSet.getInt("is_blocked"),
						RoleType.valueOf(resultSet.getString("role").toUpperCase())
				);
				return Optional.of(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public static UserDAOImpl getInstance() {
		synchronized (UserDAOImpl.class) {
			if(instance == null) {
				instance = new UserDAOImpl();
			}
		}
		return instance;
	}
}
