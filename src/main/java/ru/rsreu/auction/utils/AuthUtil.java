package ru.rsreu.auction.utils;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.enums.Routes;
import ru.rsreu.auction.enums.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class AuthUtil {
	public static boolean hasPermission(String parameter, RoleType role) {
		for(Routes path: AuthConfig.getMapConfig().get(role)) {
			if(path.equals(parameter)) {
				return true;
			}
		}
		return false;
	}
}
