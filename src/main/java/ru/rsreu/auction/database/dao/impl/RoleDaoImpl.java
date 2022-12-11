package ru.rsreu.auction.database.dao.impl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.auction.data.Role;
import ru.rsreu.auction.database.ConnectionPool;
import ru.rsreu.auction.database.dao.RoleDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDaoImpl implements RoleDAO {
	private static volatile RoleDaoImpl instance;
	private final Resourcer resourcer;

	private RoleDaoImpl() {
		resourcer = ProjectResourcer.getInstance();
	}


	@Override
	public Optional<Role> findById(Long id) {
		String query = resourcer.getString("role.query.find.by.id");

		try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role(
						resultSet.getLong("id"),
						resultSet.getString("name")
				);
				return Optional.of(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Role> findByName(String roleName) {
		String query = resourcer.getString("role.query.find.by.name");

		try (PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(query)) {
			statement.setString(1, roleName);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role role = new Role(
						resultSet.getLong("id"),
						resultSet.getString("name")
				);
				return Optional.of(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public static RoleDaoImpl getInstance() {
		synchronized (RoleDaoImpl.class) {
			if (instance == null) {
				instance = new RoleDaoImpl();
			}
		}

		return instance;
	}
}
