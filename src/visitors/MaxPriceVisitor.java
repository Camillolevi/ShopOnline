package visitors;

import java.util.Iterator;

import items.AbstractBundle;
import items.Item;
import items.SingleProduct;

public class MaxPriceVisitor implements ItemVisitor {

	private double maxPrice;

	public MaxPriceVisitor() {

		maxPrice = 0;

	}

	public void visitBundle(AbstractBundle b) {

		Iterator<Item> it = b.getIterator();

		while (it.hasNext()) {

			it.next().accept(this);

		}
	}

	public void visitSingleProduct(SingleProduct s) {

		double price = s.getPrice();

		if (price > this.maxPrice) {

			this.maxPrice = price;
		}
	}

	public double getMaxPrice(Item i) {

		i.accept(this);

		return this.maxPrice;

	}

}
