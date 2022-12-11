package ru.rsreu.auction.helper;

import ru.rsreu.auction.data.User;

import javax.servlet.http.HttpSession;

public class AppHelper {

	public static User getLoginUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}

	public static void setLoginAttribute(HttpSession session, User user) {
		session.setAttribute("user", user);
	}
}
