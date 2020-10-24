package visitors;

import java.util.Iterator;

import items.AbstractBundle;
import items.Item;
import items.SingleProduct;

public class NumForPriceVisitor implements ItemVisitor {

	private int numPriceElem;

	private double price;

	public NumForPriceVisitor(int price) {

		this.numPriceElem = 0;

		this.price = price;
	}

	public void visitBundle(AbstractBundle b) {

		Iterator<Item> it = b.getIterator();

		while (it.hasNext()) {

			it.next().accept(this);

		}
	}

	public void visitSingleProduct(SingleProduct s) {

		if (s.getPrice() == this.price) {

			this.numPriceElem++;

		}

	}

	public int getNumForPriceElem(Item i) {

		i.accept(this);

		return numPriceElem;

	}

}
