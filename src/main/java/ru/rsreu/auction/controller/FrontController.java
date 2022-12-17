package ru.rsreu.auction.controller;

import ru.rsreu.auction.command.Command;
import ru.rsreu.auction.utils.SercheCommandUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Command command = SercheCommandUtil.getCommand(req);

		try {
			command.init(getServletContext(), req, resp);
			command.execute();
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Command command = SercheCommandUtil.getCommand(req);
		command.init(getServletContext(), req, resp);
		command.send();
	}
}
