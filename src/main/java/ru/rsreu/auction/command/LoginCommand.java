package ru.rsreu.auction.command;

import ru.rsreu.auction.constant.Routes;
import ru.rsreu.auction.service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginCommand extends Command{
	@Override
	public void execute() throws ServletException, IOException {
		forward(Routes.LOGIN.getName());
	}

	@Override
	public void send() throws ServletException, IOException {
		String login = getRequest().getParameter("login");
		String password = getRequest().getParameter("password");

		UserService userService = new UserService();
		if(!userService.canUserLogin(login, password)) {
			forward(Routes.LOGIN.getName());
		} else {
			userService.login(login, getRequest().getSession());
			redirect(Routes.PROFILE.getName());
		}

	}
}
