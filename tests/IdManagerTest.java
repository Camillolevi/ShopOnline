import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Card;
import client.User;
import managament.IdManager;

public class IdManagerTest {

	@Before
	public void clear(){
		
		IdManager.clear();
		
	}
	
	@Test
	public void getUserIDTest() {

		new User("name", "surname", "address", 1212);

		new User("name", "surname", "address", 1212);

		User u = new User("name", "surname", "address", 1212);

		assertEquals(3, u.getId());

	}

	@Test
	public void getCardIDTest() {

		new Card();

		Card c = new Card();

		assertEquals(2, c.getId());

	}

}
