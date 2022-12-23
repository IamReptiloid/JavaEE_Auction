package ru.rsreu.auction.command;

import ru.rsreu.auction.enums.Pages;
import ru.rsreu.auction.service.LotService;
import ru.rsreu.auction.service.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LotsCommand extends Command{
	private LotService lotService;
	@Override
	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super.init(context, request, response);
		lotService = ServiceFactory.getLotService();
	}

	@Override
	public void execute() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("lotList", lotService.getLotsByAuctionId(id));
		forward(Pages.LOTS_USER);
	}
}
