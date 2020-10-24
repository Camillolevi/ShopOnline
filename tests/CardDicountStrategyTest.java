import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Card;
import client.Cart;
import discounts.CardDiscountStrategy;
import items.SimpleSofa;

public class CardDicountStrategyTest {

	Card card;
	Cart cart;

	@Before
	public void init() {

		card = new Card();
		cart = new Cart();
		cart.setMyDiscountStrategy(new CardDiscountStrategy(card));

	}

	@Test
	public void getDiscountedPriceTest() {

		card.setEuroToPoints(10);
		card.setPointsToEuro(1);

		card.addPoints(1000);

		SimpleSofa s = new SimpleSofa("s", 300);
		cart.addItem(s, 1);

		double expected = 200;
		double actual = cart.getFinalPrice();

		assertEquals(expected, actual, 0.03);
	}
}
