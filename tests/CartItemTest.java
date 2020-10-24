import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.CartItem;
import items.SimpleSofa;
import items.SingleProduct;

public class CartItemTest {

	private SingleProduct s;
	private CartItem ci;

	@Before
	public void InitCatalogueItem() {

		s = new SimpleSofa("bed", 200);
		ci = new CartItem(s, 1);
	}

	@Test
	public void getItemTest() {

		assertEquals(s, ci.getItem());

	}

	@Test
	public void setQuantity() {

		int expected = 3;
		ci.setQuantity(expected);
		int actual = ci.getQuantity();
		assertEquals(expected, actual);
		
	}

}
