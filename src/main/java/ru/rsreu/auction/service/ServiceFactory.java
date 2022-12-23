package ru.rsreu.auction.service;

public class ServiceFactory {
	private ServiceFactory() {
	}

	public static SessionService getSessionService() {
		return new SessionService();
	}

	public static AuctionService getAuctionService() {return new AuctionService(); }
	public static LotService getLotService() {return new LotService(); }
}
