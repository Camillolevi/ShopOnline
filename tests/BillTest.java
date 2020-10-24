import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import client.User;
import items.CushionDecorator;
import items.SimpleSofa;
import items.Table;

public class BillTest {

	User u;

	@Before
	public void initUser() {

		this.u = new User("Mario", "Rossi", "viale Morgagni, 1 Firenze", 1010);
		
		u.getMyCart().addItem(new CushionDecorator(new SimpleSofa("Sofa", 250)), 1);
		u.getMyCart().addItem(new Table("Table", 100), 2);

	}

	@Test
	public void printBillTest() {

		String expected = " -------- MY SHOP -------- \n";
		
		expected = expected + "Mario Rossi\n";
		
		expected = expected + "viale Morgagni, 1 Firenze\n";
		
		expected = expected + "Sofa - Default description with two cushions - x1 265.0€ \n";
		
		expected = expected + "Table - Default description - x2 100.0€ \n";
		
		expected = expected + "total: 465.0€. \n";
		
		expected = expected + "Thank you.";
		
		String actual = u.getMyBill().printBill(u);
		
		assertEquals(expected, actual);

	}

}
