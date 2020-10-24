package items;

import java.util.Iterator;
import java.util.LinkedList;

public class Bundle extends AbstractBundle {

	private String name;

	private LinkedList<Item> myProducts;

	private String description;

	public Bundle(String name) {

		this.name = name;
		this.myProducts = new LinkedList<Item>();
		this.description = "Default description";

	}

	@Override
	public void add(Item i) throws Exception {

		this.myProducts.add(i);

	}

	@Override
	public void remove(Item i) throws Exception {

		boolean isPresent = this.myProducts.contains(i);

		if (isPresent) {

			this.myProducts.remove(i);

		} else {

			throw new Exception("Not existing item.");

		}
	}

	@Override
	public double getPrice() {

		double sum = 0;
		Iterator<Item> it = getIterator();

		while (it.hasNext()) {
			sum = sum + it.next().getPrice();
		}
		return sum;
	}

	public Iterator<Item> getIterator() {

		return this.myProducts.iterator();

	}

	@Override
	public String getName() {

		return this.name;

	}

	public LinkedList<Item> getMyProducts() {

		return myProducts;

	}

	@Override
	public String getDescription() {

		return this.description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public AbstractBundle removeDiscountDecorator() throws Exception {

		throw new Exception("Warning!");
	}

	public AbstractBundle removeBundleDecorator() throws Exception {

		throw new Exception("Warning!");
	}

}
