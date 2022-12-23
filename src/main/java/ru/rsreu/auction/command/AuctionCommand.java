package ru.rsreu.auction.command;

import ru.rsreu.auction.enums.Pages;
import ru.rsreu.auction.service.AuctionService;

import javax.servlet.ServletException;
import java.io.IOException;

public class AuctionCommand extends Command{
    @Override
    public void execute() throws ServletException, IOException {
        request.setAttribute("auctionList", AuctionService.getAllAuctions());
        forward(Pages.AUCTION);
    }

    @Override
    public void send() throws ServletException, IOException {

    }
}
