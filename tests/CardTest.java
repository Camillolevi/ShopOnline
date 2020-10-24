import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import client.Card;

public class CardTest {

	private Card card;

	@Before
	public void initCard() {
		card = new Card();
	}

	@Test
	public void setEuroToPointsTest() {
		int expected = 10;
		card.setEuroToPoints(10);
		int actual = card.getEuroToPoints();

		assertEquals(expected, actual);
	}

	@Test
	public void setPointsToEuroTest() {
		int expected = 1;
		card.setPointsToEuro(1);
		int actual = card.getPointsToEuro();

		assertEquals(expected, actual);
	}

	@Test
	public void addPointsTest() {
		card.setEuroToPoints(10);
		long expected = 100;
		card.addPoints(1000);
		long actual = card.getPoints();

		assertEquals(expected, actual);
	}

	@Test
	public void removePointsTest() {
		card.removePoints();
		long expected = 0;
		long actual = card.getPoints();

		assertEquals(expected, actual);
	}
}
