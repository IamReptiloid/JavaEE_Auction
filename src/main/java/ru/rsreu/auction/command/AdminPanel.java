package ru.rsreu.auction.command;

import ru.rsreu.auction.enums.Pages;

import javax.servlet.ServletException;
import java.io.IOException;

public class AdminPanel extends Command{
	@Override
	public void execute() throws ServletException, IOException {
		forward(Pages.ADMIN_PANEL);
	}
}
