import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.Table;

public class TableTest {

	private Table t;

	@Before
	public void initSingleProduct() {

		t = new Table("t", 250);

	}

	@Test(expected = Exception.class)
	public void addTest() throws Exception {

		t.add(new Table("a", 1.0));

	}

	@Test(expected = Exception.class)
	public void removeTest() throws Exception {

		t.remove(new Table("a", 1));

	}

	@Test
	public void getNameTest() {

		assertEquals("t", t.getName());

	}

	@Test
	public void getPriceTest() {

		assertEquals(250, t.getPrice(), 0.03);

	}

	@Test
	public void setDescriptionTest() {

		String expected = "my new description";
		t.setDescription(expected);
		String actual = t.getDescription();
		assertEquals(expected, actual);

	}

}