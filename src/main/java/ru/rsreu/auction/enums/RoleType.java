package ru.rsreu.auction.enums;

import ru.rsreu.auction.data.Role;
import ru.rsreu.auction.database.dao.DAOFactory;

public enum RoleType {
	ADMIN("Admin"),
	USER("User"),
	MODERATOR("Moderator");

	private final String role;

	RoleType(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}
}
