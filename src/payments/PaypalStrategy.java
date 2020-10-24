package payments;

import client.Cart;

public class PaypalStrategy implements PaymentStrategy {

	public PaypalStrategy() {

	}

	@Override
	public String pay(Cart c) throws Exception {

		return "Paymement done with PayPal: " + c.getFinalPrice() + "€.";
		
	}

}
