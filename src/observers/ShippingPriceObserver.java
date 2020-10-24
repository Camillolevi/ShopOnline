package observers;

import client.Cart;

public class ShippingPriceObserver implements CartObserver {

	private double bound;
	
	private double standardPrice;

	public ShippingPriceObserver(Cart c, double bound, double price) {

		this.bound = bound;
		
		this.standardPrice = price;

		c.addObserver(this);
		
	}

	@Override
	public void update(Cart c) {

		if (c.getTotal() >= bound) {

			c.setShippingPrice(0);

		}else{
			
			c.setShippingPrice(this.standardPrice);
			
		}

	}

}
