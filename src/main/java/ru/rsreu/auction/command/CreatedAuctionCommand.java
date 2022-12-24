package ru.rsreu.auction.command;

import ru.rsreu.auction.enums.Pages;
import ru.rsreu.auction.service.AuctionService;
import ru.rsreu.auction.service.ServiceFactory;
import ru.rsreu.auction.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CreatedAuctionCommand extends Command{
	private AuctionService auctionService;

	@Override
	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super.init(context, request, response);
		auctionService = ServiceFactory.getAuctionService();

	}

	@Override
	public void execute() throws ServletException, IOException {
		Optional<Integer> userId = UserUtil.getUserIdFromCookies(request.getCookies());
		request.setAttribute("auctionList", auctionService.getAuctionByUserId(userId));
		forward(Pages.CREATED_AUCTION);
	}

	@Override
	public void send() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		auctionService.updateAuction(id, name, description, status);
	}
}
