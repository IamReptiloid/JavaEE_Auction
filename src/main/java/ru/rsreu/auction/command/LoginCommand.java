package ru.rsreu.auction.command;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.data.User;
import ru.rsreu.auction.enums.Pages;
import ru.rsreu.auction.enums.RoleType;
import ru.rsreu.auction.service.ServiceFactory;
import ru.rsreu.auction.service.SessionService;
import ru.rsreu.auction.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand extends Command{
	private SessionService sessionService;
	@Override
	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super.init(context, request, response);
		sessionService = ServiceFactory.getSessionService();

	}

	@Override
	public void execute() throws ServletException, IOException {
		forward(Pages.LOGIN);
	}

	@Override
	public void send() throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User user = sessionService.createSession(login, password);
		Pages page = AuthConfig.getStartPage(user.getRole()).getPage();
		Cookie cookie = UserUtil.createUserCookie(user);

		response.addCookie(cookie);

		forward(page);
	}
}
