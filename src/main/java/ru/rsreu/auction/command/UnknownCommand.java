package ru.rsreu.auction.command;

import ru.rsreu.auction.enums.Pages;

import javax.servlet.ServletException;
import java.io.IOException;

public class UnknownCommand extends Command{
	@Override
	public void execute() throws ServletException, IOException {
		forward(Pages.ERROR);
	}
}
