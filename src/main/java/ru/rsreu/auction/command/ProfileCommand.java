package ru.rsreu.auction.command;

import ru.rsreu.auction.config.AuthConfig;
import ru.rsreu.auction.data.Session;
import ru.rsreu.auction.service.ServiceFactory;
import ru.rsreu.auction.service.SessionService;
import ru.rsreu.auction.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ProfileCommand extends Command{
	private SessionService sessionService;
	@Override
	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super.init(context, request, response);
		sessionService = ServiceFactory.getSessionService();
	}

	@Override
	public void execute() throws ServletException, IOException {
		Optional<Integer> userId = UserUtil.getUserIdFromCookies(request.getCookies());
		Optional<Session> session = userId.isPresent()
				? sessionService.getSession(userId.get())
				: Optional.empty();

		if (session.isPresent()) {
			forward(AuthConfig.getStartPage(session.get().getUser().getRole()).getPage());
		}
	}
}
