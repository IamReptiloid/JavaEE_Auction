package ru.rsreu.auction.utils;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.enums.Routes;
import ru.rsreu.auction.enums.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Set;

public class AuthUtil {
	public static boolean hasPermission(String parameter, RoleType role) {
		for(Routes path: AuthConfig.getMapConfig().get(role)) {
			if(getRout(path.getName()).equals(parameter)) {
				return true;
			}
		}
		return false;
	}

	private static String getRout(String rout) {
		String[] st = rout.split("_");
		StringBuilder sb = new StringBuilder();
		sb.append(st[0]);
		if(st.length > 1) {
			for(int i = 1; i < st.length; i++) {
				sb.append(st[i].substring(0, 1).toUpperCase() + st[i].substring(1));
			}
		}

		return sb.toString();
	}
}
