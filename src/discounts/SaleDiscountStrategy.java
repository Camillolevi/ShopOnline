package discounts;

import client.Cart;

public class SaleDiscountStrategy implements DiscountStrategy {

	private double percent;

	public SaleDiscountStrategy(double percent) {

		this.percent = percent;

	}

	@Override
	public double getDiscountedPrice(Cart c) {

		double res = c.getTotal();
		return res - res * percent;
		
	}

}
