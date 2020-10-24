import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import items.AbstractBundle;
import items.Bundle;
import items.Table;


public class AbstractBundleTest {
	
	private AbstractBundle s;
	
	@Before
	public void init() throws Exception {

		s = new Bundle("a");
		
		Table t1= new Table("t1",20); 
		
	    Table t2= new Table("t2",30);
		
	    s.add(t1);
	    
	    s.add(t2);

	
	}
	
	@Test
	public void addMinItemDiscountDecoratorTest() {
		
		s = s.addDiscountDecorator(0.1);
		
		double expected = 48;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}

	@Test
	public void addBundleDecoratorTest() {
		
		s = s.addBundleDecorator(0.1);
		
		double expected = 45;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}
	
	@Test
	public void removeDiscountDecoratorTest() throws Exception{
		
		s = s.addDiscountDecorator(0.1);
		
		s = s.addBundleDecorator(0.1);
		
		s = s.removeDiscountDecorator();
		
		double expected = 45;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}

	@Test
	public void removeBundleDecoratorTest() throws Exception{
		
		s = s.addBundleDecorator(0.1);
		
		s = s.addDiscountDecorator(0.1);
		
		s = s.removeBundleDecorator();
		
		double expected = 48;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}
	
	@Test(expected = Exception.class)
	public void removeMinDiscountDecExceptionTest() throws Exception {
		
		s = s.addBundleDecorator(0.1);
		
		s = s.removeDiscountDecorator();
		
	}
	
	@Test(expected = Exception.class)
	public void removeBundleDecExceptionTest() throws Exception {
		
		s = s.addDiscountDecorator(0.1);
		
		s = s.removeBundleDecorator();
		
	}
	
	@Test(expected = Exception.class)
	public void removeFromSimpleBundleTest() throws Exception {
		
		s = s.removeDiscountDecorator();
		
	}

}
