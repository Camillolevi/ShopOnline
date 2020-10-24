package observers;

import java.util.Iterator;

import client.Cart;
import client.CartItem;

public class TotalObserver implements CartObserver {

	public TotalObserver(Cart c) {

		c.addObserver(this);

	}

	@Override
	public void update(Cart c) {

		double tot = 0;

		Iterator<CartItem> it = c.getIterator();

		CartItem temp;
		double p;
		int q;
		while (it.hasNext()) {

			temp = it.next();

			p = temp.getItem().getPrice();

			q = temp.getQuantity();

			tot = tot + p * q;

		}

		c.setTotal(tot);

	}

}
