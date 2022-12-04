package ru.rsreu.auction.command;

import ru.rsreu.auction.constant.Routes;
import ru.rsreu.auction.database.dao.RoleDAO;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends Command{
	private RoleDAO roleDao;
	@Override
	public void execute() throws ServletException, IOException {
		forward(Routes.ERROR.getName());
	}
}
