package managament;

import java.util.Iterator;
import java.util.LinkedList;

import items.Item;

public final class Catalogue {

	private static volatile Catalogue catalogue;

	private LinkedList<Item> allShopItems;

	private Catalogue() {

		allShopItems = new LinkedList<Item>();

	}

	public static synchronized Catalogue getCatalogue() {

		if (catalogue == null) {

			catalogue = new Catalogue();

		}

		return catalogue;

	}

	public LinkedList<Item> getAllShopItems() {

		Catalogue c = Catalogue.getCatalogue();
		return c.allShopItems;

	}

	public boolean findItem(Item item) {

		Catalogue c = Catalogue.getCatalogue();
		return c.allShopItems.contains(item);

	}

	public Iterator<Item> getIterator() {

		Catalogue c = Catalogue.getCatalogue();
		Iterator<Item> it = c.allShopItems.iterator();
		return it;

	}

	public void addItem(Item i) {

		if (i != null) {

			Catalogue c = Catalogue.getCatalogue();

			c.getAllShopItems().add(i);

		}

	}

	public void removeItem(Item i) {

		Catalogue c = Catalogue.getCatalogue();

		c.allShopItems.remove(i);

	}

}
