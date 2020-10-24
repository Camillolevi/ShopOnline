import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Cart;
import items.SimpleSofa;

public class LambdaDiscountStrategyTest {

	private Cart c;

	@Before
	public void initCart() {

		c = new Cart();

		c.setMyDiscountStrategy((c) -> c.getTotal() / 2);

	}

	@Test
	public void getDiscountedPriceTest() {

		SimpleSofa s = new SimpleSofa("a", 100);
		c.addItem(s, 3);
		double actual = c.getFinalPrice();
		assertEquals(150, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceEmptyCartTest() {

		double actual = c.getFinalPrice();
		assertEquals(0, actual, 0.03);

	}
}
