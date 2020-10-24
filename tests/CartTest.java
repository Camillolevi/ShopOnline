import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import client.Cart;
import items.SimpleSofa;
import items.SingleProduct;
import items.Table;

public class CartTest {

	private Cart c;

	@Before
	public void initCart() {

		c = new Cart();

	}

	@Test
	public void findItemPositiveTest() {

		SingleProduct s = new SimpleSofa("one", 1);
		c.addItem(s, 1);
		assertNotNull(c.findItem(s));

	}

	@Test
	public void findItemNegativeTest() {

		Table s = new Table("one", 1.0);

		assertNull(c.findItem(s));

	}

	@Test
	public void removeItemPositiveTest() throws Exception {

		Table s = new Table("one", 1.0);

		c.addItem(s, 3);

		try {

			c.removeItem(s);

		} catch (Exception e) {

		}

		assertNull(c.findItem(s));

	}

	@Test(expected = Exception.class)
	public void removeItemNegativeItem() throws Exception {

		Table s = new Table("one", 1.0);

		try {
			c.removeItem(s);

		} catch (Exception e) {
			throw e;
		}

	}

	@Test
	public void getFinalPriceAddNotifyTest() {

		SingleProduct s1 = new SimpleSofa("", 2.5);
		SingleProduct s2 = new SimpleSofa("", 10);

		c.addItem(s1, 2);
		c.addItem(s2, 3);

		assertEquals(35, c.getFinalPrice(), 0.03);

	}

	@Test
	public void getFinalPricePriceEmptyCartTest() {

		assertEquals(0, c.getFinalPrice(), 0.03);

	}

	@Test
	public void getFinalPriceRemoveNotifyTest() {

		SingleProduct s1 = new SimpleSofa("", 2.5);
		SingleProduct s2 = new SimpleSofa("", 10);

		c.addItem(s1, 2);
		c.addItem(s2, 3);
		try {
			c.removeItem(s1);
		} catch (Exception e) {
		}

		assertEquals(30, c.getFinalPrice(), 0.03);

	}

	@Test
	public void getTotalChangeQuantityNotifyTest() {

		SingleProduct s1 = new SimpleSofa("", 2.5);
		SingleProduct s2 = new SimpleSofa("", 10);

		c.addItem(s1, 2);
		c.addItem(s2, 3);
		c.changeQuantity(s2, 1);

		assertEquals(15, c.getFinalPrice(), 0.03);

	}

	@Test
	public void getShippingPriceObserverTest() {

		SimpleSofa s = new SimpleSofa("", 250);

		c.addItem(s, 1);

		assertEquals(6.5, c.getShippingPrice(), 0.03);

	}

	@Test
	public void getShippingPriceEmptyCartTest() {

		assertEquals(6.5, c.getShippingPrice(), 0.03);

	}

	@Test
	public void getShippingPriceBoundTest() {

		SimpleSofa s = new SimpleSofa("", 500);

		c.addItem(s, 2);

		assertEquals(0, c.getShippingPrice(), 0.03);

	}
	
	@Test
	public void getShippingPriceRemoveNotifyTest() {

		SimpleSofa s = new SimpleSofa("", 700);
		
		c.addItem(s, 2);
		
		c.changeQuantity(s, 1);
		
		assertEquals(6.5, c.getShippingPrice(), 0.03);

	}


}
