package client;

import managament.IdManager;

public class Card {

	private final int id;

	private long points;

	private int euroToPoints; // 10 euro
	
	private int pointsToEuro; // 1 euro

	public Card() {
		
		this.id = IdManager.getCardID();
		this.points = 0;
		this.euroToPoints = 10;
		this.pointsToEuro = 1;

	}

	public int getEuroToPoints() {
		return euroToPoints;
	}

	public void setEuroToPoints(int euroToPoints) {
		this.euroToPoints = euroToPoints;
	}
	

	public int getPointsToEuro() {
		return pointsToEuro;
	}

	public void setPointsToEuro(int pointsToEuro) {
		this.pointsToEuro = pointsToEuro;
	}

	public int getId() {
		return id;
	}

	public long getPoints() {
		return points;
	}

	public void addPoints(int price) {

		this.points = this.points + price / euroToPoints;

	}

	public void removePoints() {

		this.points = 0;

	}

}

