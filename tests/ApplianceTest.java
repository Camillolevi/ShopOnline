
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import items.Appliance;

public class ApplianceTest {

	private Appliance s;

	@Before
	public void initSingleProduct() {

		s = new Appliance("a", 250, 2017);

	}

	@Test(expected = Exception.class)
	public void addTest() throws Exception {

		s.add(new Appliance("a", 1.0, 2017));

	}

	@Test(expected = Exception.class)
	public void removeTest() throws Exception {

		s.remove(new Appliance ("a", 1, 2017));

	}
	
	@Test
	public void getNameTest() {

		assertEquals("a", s.getName());

	}
	
	@Test
	public void getPriceTest() {

		assertEquals(250, s.getPrice(), 0.03);

	}

	@Test
	public void setDescriptionTest() {

		String expected = "my new description";
		s.setDescription(expected);
		String actual = s.getDescription();
		assertEquals(expected, actual);

	}

}
