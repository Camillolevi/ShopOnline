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
import visitors.NumForPriceVisitor;

public class NumForPriceVisitorTest {

	private NumForPriceVisitor v;

	private Appliance s1;

	private SimpleSofa s2;

	private StorageFurniture s3;

	private Bundle b;

	@Before
	public void initVis() {

		v = new NumForPriceVisitor(20);

		s1 = new Appliance("n1", 20, 1017);

		s2 = new SimpleSofa("n2", 20);

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

		double expected = 1;

		double actual = v.getNumForPriceElem(s1);

		assertEquals(expected, actual, 0.03);

	}

	@Test
	public void visitBundleTest() {

		double expected = 2;

		double actual = v.getNumForPriceElem(b);

		assertEquals(expected, actual, 0.03);

	}

}
