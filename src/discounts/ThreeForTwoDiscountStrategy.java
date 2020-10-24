package discounts;

import java.util.Iterator;

import client.Cart;
import client.CartItem;

public class ThreeForTwoDiscountStrategy implements DiscountStrategy {

	public ThreeForTwoDiscountStrategy() {

	}

	@Override
	public double getDiscountedPrice(Cart c) {

		double res = c.getTotal();

		Iterator<CartItem> it = c.getIterator();

		CartItem temp;

		while (it.hasNext()) {

			temp = it.next();

			res = res - getDiscount(temp);

		}

		return res;

	}

	private double getDiscount(CartItem ci) {

		int q = ci.getQuantity() / 3;

		double discount = (ci.getItem().getPrice()) * q;

		return discount;
	}

}
