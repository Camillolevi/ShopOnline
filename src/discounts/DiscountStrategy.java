package discounts;

import client.Cart;

@FunctionalInterface
public interface DiscountStrategy {
	
	public double getDiscountedPrice(Cart c);
	
}
