package ru.rsreu.auction.service;

import ru.rsreu.auction.data.User;
import ru.rsreu.auction.database.dao.DAOFactory;
import ru.rsreu.auction.database.dao.UserDAO;
import ru.rsreu.auction.helper.AppHelper;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class UserService {
	private UserDAO userDAO = DAOFactory.getUserDAO();

	public boolean canUserLogin(String login, String password) {
		Optional<User> user = userDAO.gerUserByLogin(login);
		return (user.isPresent() && user.get().getPassword().equals(password)); // TODO isBlocked
	}

	public void login(String login, HttpSession session) {
		Optional<User> user = userDAO.gerUserByLogin(login);
		if(user.isPresent()) {
			// TODO Update BD
			AppHelper.setLoginAttribute(session, user.get());
		}
	}
}
