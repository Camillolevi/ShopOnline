package payments;

import client.Cart;

public class PaymentOnDelivery implements PaymentStrategy {
	
	private double increment;

	public PaymentOnDelivery(double increment) {
		
		this.increment = increment;
		
	}



	public String pay(Cart c) throws Exception {
		
		double finalPrice = c.getFinalPrice();

		return "Payment on delivery: " + finalPrice + "€ plus " + this.increment + "€.";

	}

}
