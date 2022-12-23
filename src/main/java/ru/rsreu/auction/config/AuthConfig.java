package ru.rsreu.auction.config;

import ru.rsreu.auction.enums.Routes;
import ru.rsreu.auction.enums.RoleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthConfig {
	private static final Map<RoleType, ArrayList<Routes>> mapConfig = new HashMap<>();
	private static final Map<RoleType, Routes> startPage = new HashMap<>();

	static  {
		init();
	}

	private static void init() {
		ArrayList<Routes> userUrlPatterns = new ArrayList<>();
		userUrlPatterns.add(Routes.PROFILE);
		userUrlPatterns.add(Routes.AUCTION);

		mapConfig.put(RoleType.USER, userUrlPatterns);

		ArrayList<Routes> adminUrlPatterns = new ArrayList<>();
		userUrlPatterns.add(Routes.ADMIN_PANEL);
		mapConfig.put(RoleType.ADMINISTRATOR, adminUrlPatterns);

		startPage.put(RoleType.USER, Routes.PROFILE);
		startPage.put(RoleType.ADMINISTRATOR, Routes.ADMIN_PANEL);
	}

	public static Set<RoleType> getAllRoles() {
		return mapConfig.keySet();
	}

	public static Map<RoleType, ArrayList<Routes>> getMapConfig() {
		return mapConfig;
	}
	public static Routes getStartPage(RoleType role) {
		return startPage.get(role);
	}
}
