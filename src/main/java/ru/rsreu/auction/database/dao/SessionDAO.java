package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.data.Session;

import java.util.Optional;

public interface SessionDAO {
	void save(Session session);
	Optional<Session> findByUserId(int id);
}
