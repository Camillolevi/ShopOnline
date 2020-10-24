package visitors;

import java.util.Iterator;

import items.AbstractBundle;
import items.Item;
import items.SingleProduct;

public class MinPriceVisitor implements ItemVisitor {

	private double minPrice;

	public MinPriceVisitor() {

		this.minPrice = 1000000;

	}

	public void visitBundle(AbstractBundle b) {

		Iterator<Item> it = b.getIterator();

		while (it.hasNext()) {

			it.next().accept(this);

		}
	}

	public void visitSingleProduct(SingleProduct s) {

		double price = s.getPrice();

		if (price < this.minPrice) {

			this.minPrice = price;

		}
	}

	public double getMinPrice(Item i) {

		i.accept(this);

		return this.minPrice;

	}

}
