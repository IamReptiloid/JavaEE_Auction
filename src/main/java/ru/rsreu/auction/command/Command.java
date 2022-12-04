package ru.rsreu.auction.command;

import ru.rsreu.auction.handler.Rout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class Command extends Rout {
	public void execute() throws ServletException, IOException {};
	public void send() throws ServletException, IOException {};
}
