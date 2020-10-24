import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import client.User;
import discounts.BirthdayDiscountStrategy;
import items.Appliance;
import items.DoorDecorator;
import items.ShelfDecorator;
import items.SimpleSofa;
import items.SimpleStorageFurniture;
import items.SingleProduct;

public class BirthdayDiscountStrategyTest {

	private User u;
	private int today;

	@Before
	public void initUser() {

		this.u = new User("name", "surname", "address", 1010);

		this.today = 1010;

		if (today == u.getBirthday()) {

			BirthdayDiscountStrategy d = new BirthdayDiscountStrategy(20, 100);

			u.getMyCart().setMyDiscountStrategy(d);

		}
	}

	@Test
	public void getDiscountedPriceTest() {

		Appliance s = new Appliance("a", 60, 2017);
		u.getMyCart().addItem(s, 3);
		double expected = 160;
		double actual = u.getMyCart().getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceNoDiscountTest() {

		SimpleSofa s = new SimpleSofa("a", 60);
		u.getMyCart().addItem(s, 1);
		double expected = 60;
		double actual = u.getMyCart().getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceBoundCaseTest() {

		SingleProduct s = new DoorDecorator(new ShelfDecorator(new SimpleStorageFurniture("n3", 20)));
		u.getMyCart().addItem(s, 2);
		double expected = 80;
		double actual = u.getMyCart().getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDiscountedPriceEmptyCartTest() {

		double expected = 0;
		double actual = u.getMyCart().getFinalPrice();
		assertEquals(expected, actual, 0.03);

	}

}
