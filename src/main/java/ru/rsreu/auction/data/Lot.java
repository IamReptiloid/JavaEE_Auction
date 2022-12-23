package ru.rsreu.auction.data;

import java.util.Date;

public class Lot {
	private long id;
	private int price;
	private Date closingDate;
	private String description;
	private String pathToPicture;
	private int step;
	private String status;
	private String name;
	private String winner;

	public Lot(long id, int price, Date closingDate, String description, String pathToPicture, int step, String status, String name, String winner) {
		this.id = id;
		this.price = price;
		this.closingDate = closingDate;
		this.description = description;
		this.pathToPicture = pathToPicture;
		this.step = step;
		this.status = status;
		this.name = name;
		this.winner = winner;
	}

	public long getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public String getDescription() {
		return description;
	}

	public String getPathToPicture() {
		return pathToPicture;
	}

	public int getStep() {
		return step;
	}

	public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public String getWinner() {
		return winner;
	}
}
