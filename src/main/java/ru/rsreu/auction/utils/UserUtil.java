package ru.rsreu.auction.utils;

import ru.rsreu.auction.data.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class UserUtil {
	private static final String USER_ID = "user_id";
	private static final int COOKIE_MAX_AGE = 60 * 60;

	private UserUtil() {
	}

	public static Cookie createUserCookie(User user) {
		Cookie cookie = new Cookie(USER_ID, user.getId().toString());

		cookie.setMaxAge(COOKIE_MAX_AGE);

		return cookie;
	}

	public static Optional<Integer> getUserIdFromCookies(Cookie[] cookies) {
		if (cookies == null) {
			return Optional.empty();
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(USER_ID)) {
				String value = cookie.getValue();

				return value == null
						? Optional.empty()
						: Optional.of(Integer.parseInt(value));
			}
		}

		return Optional.empty();
	}
}
