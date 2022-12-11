package ru.rsreu.auction.config;

import ru.rsreu.auction.constant.Routes;
import ru.rsreu.auction.enums.RoleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthConfig {
	private static final Map<String, ArrayList<String>> mapConfig = new HashMap<>();

	static  {
		init();
	}

	private static void init() {
		ArrayList<String> userUrlPatterns = new ArrayList<>();
		userUrlPatterns.add(Routes.PROFILE.getName());

		mapConfig.put(RoleType.USER.getRole(), userUrlPatterns);

		ArrayList<String> adminUrlPatterns = new ArrayList<>();
		userUrlPatterns.add(Routes.PROFILE.getName());
		mapConfig.put(RoleType.ADMIN.getRole(), userUrlPatterns);
	}

	public static Set<String> getAllRoles() {
		return mapConfig.keySet();
	}

	public static Map<String, ArrayList<String>> getMapConfig() {
		return mapConfig;
	}
}
