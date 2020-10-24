import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Cart;
import discounts.SaleDiscountStrategy;
import items.SimpleSofa;

public class SaleDiscountStrategyTest {

	private Cart c;

	@Before
	public void initCart() {

		c = new Cart();
		SaleDiscountStrategy d = new SaleDiscountStrategy(0.2);
		c.setMyDiscountStrategy(d);

	}

	@Test
	public void getDiscountedPriceTest() {

		SimpleSofa s = new SimpleSofa("a", 100);
		c.addItem(s, 3);
		double expected = 240;
		double actual = c.getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceEmptyCartTest() {

		double expected = 0;
		double actual = c.getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

}
