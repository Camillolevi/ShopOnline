import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import items.Appliance;
import items.Bundle;
import items.DoorDecorator;
import items.ShelfDecorator;
import items.SimpleSofa;
import items.SimpleStorageFurniture;
import items.StorageFurniture;
import visitors.MaxPriceVisitor;

public class MaxPriceVisitorTest {

	private MaxPriceVisitor v;

	private Appliance s1;

	private SimpleSofa s2;

	private StorageFurniture s3;

	private Bundle b;

	@Before
	public void initVis() {

		v = new MaxPriceVisitor();

		s1 = new Appliance("n1", 20, 1017);

		s2 = new SimpleSofa("n2", 30);

		s3 = new DoorDecorator(new ShelfDecorator(new SimpleStorageFurniture("n3", 12)));

		b = new Bundle("bundle");

		try {

			b.add(s1);
			b.add(s2);
			b.add(s3);

		} catch (Exception e) {
		}

	}

	@Test
	public void visitSingleProductTest() {

		double expected = s1.getPrice();

		double actual = v.getMaxPrice(s1);

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void visitBundleTest() {

		double expected = 42;

		double actual = v.getMaxPrice(b);

		assertEquals(expected, actual, 0.03);

	}

}
