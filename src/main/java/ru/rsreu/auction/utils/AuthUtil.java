package ru.rsreu.auction.utils;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.enums.Routes;
import ru.rsreu.auction.enums.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class AuthUtil {

	public static boolean isSecurity(HttpServletRequest request) {
		Set<RoleType> roles = AuthConfig.getAllRoles();
		String param = request.getParameter(GlobalConst.PARAMS_PAGE);
		for(RoleType role: roles) {
			if(AuthConfig.getMapConfig().get(role).contains(param)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasPermission(HttpServletRequest request, RoleType role) {
		String param = request.getParameter(GlobalConst.PARAMS_PAGE);
		for(Routes path: AuthConfig.getMapConfig().get(role.getRole())) {
			if(path.equals(param)) {
				return true;
			}
		}
		return false;
	}
}
