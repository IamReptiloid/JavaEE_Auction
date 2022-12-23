package ru.rsreu.auction.filter;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.constant.GlobalConst;
import ru.rsreu.auction.data.Session;
import ru.rsreu.auction.enums.Pages;
import ru.rsreu.auction.enums.Routes;
import ru.rsreu.auction.service.ServiceFactory;
import ru.rsreu.auction.service.SessionService;
import ru.rsreu.auction.utils.AuthUtil;
import ru.rsreu.auction.utils.UserUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthFilter implements Filter {
	private SessionService sessionService;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		sessionService = ServiceFactory.getSessionService();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		Optional<Integer> userId = UserUtil.getUserIdFromCookies(request.getCookies());
		Optional<Session> session = userId.isPresent()
				? sessionService.getSession(userId.get())
				: Optional.empty();
		if(!session.isPresent()){
			String path = request.getParameter(GlobalConst.PARAMS_PAGE);
			if (path.contains(Routes.LOGIN.getName())) {
				filterChain.doFilter(request, response);
				return;
			}
			response.sendRedirect(Pages.LOGIN.getPage());
			return;
		}

		//TODO
		if((AuthUtil.isSecurity(request) && !AuthUtil.hasPermission(request, session.get().getUser().getRole()))) {
			response.sendRedirect(AuthConfig.getStartPage(session.get().getUser().getRole()).getPage().getPage());
			return;
		}

		String path = request.getParameter(GlobalConst.PARAMS_PAGE);
		if (path.contains(Routes.LOGIN.getName())) {
			response.sendRedirect(AuthConfig.getStartPage(session.get().getUser().getRole()).getPage().getPage());
			return;
		}

        filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
