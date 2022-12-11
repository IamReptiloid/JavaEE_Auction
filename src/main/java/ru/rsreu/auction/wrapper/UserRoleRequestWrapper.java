package ru.rsreu.auction.wrapper;

import ru.rsreu.auction.data.Role;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.enums.RoleType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
	private final User user;
	private final RoleType role;
	private final HttpServletRequest request;

	public UserRoleRequestWrapper(User user, RoleType role, HttpServletRequest request) {
		super(request);
		this.user = user;
		this.role = role;
		this.request = request;
	}


}

