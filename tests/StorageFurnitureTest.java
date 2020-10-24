import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import items.DoorDecorator;
import items.ShelfDecorator;
import items.SimpleStorageFurniture;
import items.StorageFurniture;

public class StorageFurnitureTest {

	private StorageFurniture s;
	private StorageFurniture decoratedFurniture;

	@Before
	public void initSingleProduct() {

		s = new SimpleStorageFurniture("bed", 250);

		decoratedFurniture = new DoorDecorator(new ShelfDecorator(new SimpleStorageFurniture("bed", 250)));

	}

	@Test(expected = Exception.class)
	public void addTest() throws Exception {

		s.add(s);

	}

	@Test(expected = Exception.class)
	public void removeTest() throws Exception {

		s.remove(s);

	}

	@Test
	public void getSimplePriceTest() {

		double expected = 250;

		double actual = s.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getDecoratedPriceTest() {

		double expected = 280;

		double actual = decoratedFurniture.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void getName() {

		assertEquals("bed", s.getName());
	}

	@Test
	public void getDecoratedName() {

		assertEquals("bed", decoratedFurniture.getName());
	}

	@Test
	public void setSimpleDescriptionTest() {

		String expected = "My new description";

		s.setDescription(expected);

		String actual = s.getDescription();

		assertEquals(expected, actual);

	}

	@Test
	public void setDecoratedDescriptionTest() {

		String expected = "My new description";

		decoratedFurniture.setDescription(expected);

		String actual = decoratedFurniture.getDescription();

		assertEquals(expected + " plus six shelves plus two doors", actual);

	}

	@Test
	public void addDoorDecoratorTest() {

		s = s.addDoorDecorator();

		double expected = 260;

		double actual = s.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void addShelsDecoratorTest() {

		s = s.addShelfDecorator();

		double expected = 270;

		double actual = s.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void removeDoorDecoratorTest() throws Exception {

		// starting price = 280
		decoratedFurniture = decoratedFurniture.removeDoorDecorator();

		double expected = 270;

		double actual = decoratedFurniture.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void removeShelfDecoratorTest() throws Exception {

		// starting price = 280
		decoratedFurniture = decoratedFurniture.removeShelfDecorator();

		double expected = 260;

		double actual = decoratedFurniture.getPrice();

		assertEquals(expected, actual, 0.03);

	}

	@Test(expected = Exception.class)
	public void removeShelfExceptionTest() throws Exception {

		decoratedFurniture = decoratedFurniture.removeShelfDecorator();

		decoratedFurniture = decoratedFurniture.removeShelfDecorator();

	}

	@Test(expected = Exception.class)
	public void removeDoorExceptionTest() throws Exception {

		decoratedFurniture = decoratedFurniture.removeDoorDecorator();

		decoratedFurniture = decoratedFurniture.removeDoorDecorator();

	}

	@Test(expected = Exception.class)
	public void removeDecSimpleTest() throws Exception {

		s = s.removeDoorDecorator();

	}

}
