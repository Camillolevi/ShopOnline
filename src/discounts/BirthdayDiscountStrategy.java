package discounts;

import client.Cart;

public class BirthdayDiscountStrategy implements DiscountStrategy {

	int coupon;
	double bound;

	public BirthdayDiscountStrategy(int coupon, double bound) {

		this.coupon = coupon;
		this.bound = bound;

	}

	@Override
	public double getDiscountedPrice(Cart c) {

		double res = c.getTotal();

		if (res >= this.bound) {

			res = res - this.coupon;

		}
		return res;
	}

}
