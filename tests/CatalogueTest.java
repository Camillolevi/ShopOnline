import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.SimpleSofa;
import items.SimpleStorageFurniture;
import items.Table;
import managament.Catalogue;

public class CatalogueTest {

	private Catalogue s;

	@Before
	public void initStorehouse() {

		s = Catalogue.getCatalogue();
		s.getAllShopItems().clear();

	}

	@Test
	public void findItemPositiveTest() {

		Table p = new Table("a", 100);
		s.addItem(p);

		assertTrue(s.findItem(p));

	}

	@Test
	public void findItemNegativeTest() {

		SimpleSofa p = new SimpleSofa("a", 100);
		assertFalse(s.findItem(p));

	}

	@Test
	public void removeTest() {

		SimpleStorageFurniture p = new SimpleStorageFurniture("a", 100);

		s.addItem(p);

		s.removeItem(p);

		assertFalse(s.findItem(p));

	}

}
