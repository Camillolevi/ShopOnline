package payments;

import client.Cart;

public interface PaymentStrategy {

	public String pay(Cart c) throws Exception;

}
