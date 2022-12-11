package ru.rsreu.auction.filter;

import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.helper.AppHelper;
import ru.rsreu.auction.helper.AuthHelper;
import ru.rsreu.auction.wrapper.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

//		String param = request.getParameter(GlobalConst.PARAMS_PAGE);

//		if (param.equals("login")) {
//			System.out.println("login");
//			filterChain.doFilter(request, response);
//			return;
//		}

		User user = AppHelper.getLoginUser(request.getSession());
		HttpServletRequest wrapRequest = request;

		if(user != null) {
			wrapRequest = new UserRoleRequestWrapper(user, user.getRole(), request);
		}

		if(AuthHelper.isSecurity(wrapRequest)) {
			if(user == null) {
				response.sendRedirect("/auction?command=login");
			}

			boolean hasPermission = AuthHelper.hasPermission(wrapRequest, user.getRole());

			if(!hasPermission) {
				response.sendRedirect("/auction?command=profile");
				return;
			}
		}

		filterChain.doFilter(wrapRequest, response);
	}

	@Override
	public void destroy() {

	}
}
