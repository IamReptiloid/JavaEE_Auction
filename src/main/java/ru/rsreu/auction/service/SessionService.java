package ru.rsreu.auction.service;

import ru.rsreu.auction.data.Session;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.database.dao.DAOFactory;
import ru.rsreu.auction.database.dao.SessionDAO;
import ru.rsreu.auction.database.dao.UserDAO;

import java.util.Date;
import java.util.Optional;

import static ru.rsreu.auction.constant.GlobalConst.SESSION_TIME_LIVE;

public class SessionService {
	private UserDAO userDAO = DAOFactory.getUserDAO();
	private SessionDAO sessionDAO = DAOFactory.getSessionDAO();

	public User createSession(String login, String password) {
		Optional<User> user = this.userDAO.gerUserByLogin(login);

		if(!user.isPresent() || !user.get().getPassword().equals(password)) {
			throw new RuntimeException();
		}

		Date date = new Date(System.currentTimeMillis() + SESSION_TIME_LIVE);
		Session session = new Session(date, user.get());

		sessionDAO.save(session);

		return user.get();
	}

	public Optional<Session> getSession(Integer id) {
		return sessionDAO.findByUserId(id.intValue());
	}
}
