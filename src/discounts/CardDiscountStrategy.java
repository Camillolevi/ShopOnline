package discounts;

import client.Card;
import client.Cart;

public class CardDiscountStrategy implements DiscountStrategy {

	private Card card;

	public CardDiscountStrategy(Card card) {

		this.card = card;

	}

	@Override
	public double getDiscountedPrice(Cart c) {

		double res = c.getTotal();

		double cardValue = card.getPointsToEuro() * card.getPoints();

		if (res > cardValue) {

			res = res - cardValue;
			card.removePoints();

		}

		return res;

	}

}
