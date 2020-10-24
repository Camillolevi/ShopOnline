
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Cart;
import discounts.ThreeForTwoDiscountStrategy;
import items.Appliance;
import items.DoorDecorator;
import items.ShelfDecorator;
import items.SimpleStorageFurniture;
import items.SingleProduct;
import items.Table;

public class ThreeForTwoDiscountStrategyTest {

	private Cart c;

	@Before
	public void initCart() {

		c = new Cart();
		ThreeForTwoDiscountStrategy d = new ThreeForTwoDiscountStrategy();
		c.setMyDiscountStrategy(d);

	}

	@Test
	public void getDiscountedPriceTest() {

		Appliance s = new Appliance("a", 100, 2017);
		c.addItem(s, 3);
		double expected = 200;
		double actual = c.getMyDiscountStrategy().getDiscountedPrice(c);
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceTwoItemsTest() {

		Table s = new Table("a", 5);
		c.addItem(s, 2);
		double expected = 10;
		double actual = c.getMyDiscountStrategy().getDiscountedPrice(c);
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceFourItemsTest() {

		SimpleStorageFurniture s = new SimpleStorageFurniture("a", 100);
		c.addItem(s, 4);
		double expected = 300;
		double actual = c.getMyDiscountStrategy().getDiscountedPrice(c);
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceSixItemsTest() {

		SingleProduct s = new DoorDecorator(new ShelfDecorator(new SimpleStorageFurniture("n3", 100)));
		c.addItem(s, 6);
		double expected = 520;
		double actual = c.getMyDiscountStrategy().getDiscountedPrice(c);
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceEmptyCartTest() {

		double expected = 0;
		double actual = c.getMyDiscountStrategy().getDiscountedPrice(c);
		assertEquals(expected, actual, 0.03);

	}

}
