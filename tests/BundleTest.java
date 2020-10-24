import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.AbstractBundle;
import items.Appliance;
import items.Bundle;
import items.BundleTotDiscountDecorator;
import items.DoorDecorator;
import items.MinItemDiscountDecorator;
import items.SimpleStorageFurniture;
import items.Table;

public class BundleTest {

	private Bundle b;

	private AbstractBundle minItemDiscountDecorated;
	
	private AbstractBundle totDiscountDecorated;

	@Before
	public void initSingleProduct() {

		b = new Bundle("kitchen");
		
		try {
			b.add(new Appliance("oven", 250, 2017));
			b.add(new Appliance("fridge", 500, 2017));
			b.add(new DoorDecorator(new SimpleStorageFurniture("s", 100)));
		} catch (Exception e) {
		}
		
		minItemDiscountDecorated = new MinItemDiscountDecorator(b, 0.5);
		totDiscountDecorated = new BundleTotDiscountDecorator(b, 0.1);

	}

	@Test
	public void addTest() throws Exception {

		Table t = new Table("t",100);
		b.add(t);
		assertTrue(b.getMyProducts().contains(t));

	}

	@Test(expected = Exception.class)
	public void removeNotExistingItemTest() throws Exception {

		Table t = new Table("t",100);
		b.remove(t);

	}
	
	@Test
	public void removeTest() throws Exception {

		Table t = new Table("t",100);
		b.add(t);
		b.remove(t);
		assertFalse(b.getMyProducts().contains(t));

	}

	@Test
	public void getSimplePriceTest() {

		double expected = 860;

		double actual = b.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getMinItemDiscountTest() {

		double expected = 805;

		double actual = minItemDiscountDecorated.getPrice();

		assertEquals(expected, actual, 0.03);

	}
	
	@Test
	public void getTotDiscountTest() {

		double expected = 774;

		double actual = totDiscountDecorated.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getSimpleName() {

		assertEquals("kitchen", b.getName());
	}
	
	@Test
	public void getComposedName() {

		assertEquals("kitchen", minItemDiscountDecorated.getName());
	}

	@Test
	public void setSimpleDescriptionTest() {

		String expected = "My new description";

		b.setDescription(expected);

		String actual = b.getDescription();

		assertEquals(expected, actual);

	}

	@Test
	public void setComposedDescriptionTest() {

		String expected = "My new description";

		minItemDiscountDecorated.setDescription(expected);

		String actual = minItemDiscountDecorated.getDescription();

		assertEquals(expected + " with a discount on the cheaper item by 50.0%.", actual);

	}
	
}
