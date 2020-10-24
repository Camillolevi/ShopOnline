import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import items.CushionDecorator;
import items.SimpleSofa;
import items.Sofa;

public class SofaTest {

	private Sofa s;
	private Sofa decoratedSofa;

	@Before
	public void initSingleProduct() {

		s = new SimpleSofa("sofa", 250);

		decoratedSofa = new CushionDecorator(new SimpleSofa("sofa", 250));

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

		double expected = 265;

		double actual = decoratedSofa.getPrice();

		assertEquals(expected, actual, 0.03);

	}
	
	@Test
	public void getName(){
		
		assertEquals("sofa", s.getName());
		
	}
	
	@Test
	public void getDecoratedName(){
		
		assertEquals("sofa", decoratedSofa.getName());
		
	}

	@Test
	public void setDescriptionSimpleTest() {

		String expected = "my new description";
		s.setDescription(expected);
		String actual = s.getDescription();
		assertEquals(expected, actual);

	}

	@Test
	public void setDecoratedDescriptionTest() {

		String expected = "my new description";
		
		decoratedSofa.setDescription(expected);
		
		String actual = decoratedSofa.getDescription();
		
		assertEquals(expected + " with two cushions", actual);

	}
	
	@Test
	public void addCushionDecoratorTest(){
		
		s = s.addCushionsDecorator();
		
		double expected = 265;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}
	
	
	@Test
	public void removeCushionDecoratorTest() throws Exception{
		
		// starting price = 265 
		decoratedSofa = decoratedSofa.removeCushionsDecorator();
		
		double expected = 250;
		
		double actual = s.getPrice();
		
		assertEquals(expected, actual, 0.03);
		
	}
	
	@Test(expected = Exception.class)
	public void removeCushionExceptionTest()throws Exception {
		
		decoratedSofa = decoratedSofa.removeCushionsDecorator();
		
		decoratedSofa = decoratedSofa.removeCushionsDecorator();
		
	}
	
	@Test(expected = Exception.class)
	public void removeCushionSimpleTest()throws Exception {
		
		s = s.removeCushionsDecorator();
		
	}

}
