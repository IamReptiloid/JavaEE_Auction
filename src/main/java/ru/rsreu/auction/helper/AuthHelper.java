package ru.rsreu.auction.helper;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.enums.RoleType;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class AuthHelper {

	public static boolean isSecurity(HttpServletRequest request) {
		Set<String> roles = AuthConfig.getAllRoles();
		String param = request.getParameter(GlobalConst.PARAMS_PAGE);
		for(String role: roles) {
			if(AuthConfig.getMapConfig().get(role).contains(param)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasPermission(HttpServletRequest request, RoleType role) {
		String param = request.getParameter(GlobalConst.PARAMS_PAGE);
		for(String path: AuthConfig.getMapConfig().get(role.getRole())) {
			if(path.equals(param)) {
				return true;
			}
		}
		return false;
	}
}
