package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.data.User;

import java.util.Optional;

public interface UserDAO {
	Optional<User>  getUserById(Long id);
	Optional<User> gerUserByLogin(String login);
}
