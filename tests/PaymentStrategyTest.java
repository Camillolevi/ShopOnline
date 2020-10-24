
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import client.Cart;
import payments.CreditCardStrategy;
import payments.PaymentOnDelivery;
import payments.PaymentStrategy;
import payments.PaypalStrategy;

public class PaymentStrategyTest {

	@Test
	public void payByCreditCardTest() {

		Calendar day = Calendar.getInstance();
		day.set(2027, 01, 23);
		PaymentStrategy p = new CreditCardStrategy("Mario Rossi", "35623522", "2356", day);

		try {

			String s = p.pay(new Cart());

			assertEquals("Paymement done with credit card: 0.0€.", s);

		} catch (Exception e) {

		}

	}

	@Test(expected = Exception.class)
	public void payFailureByCreditCardTest() throws Exception {

		Calendar day = Calendar.getInstance();
		day.set(2014, 01, 23);
		PaymentStrategy p = new CreditCardStrategy("Mario Rossi", "35623522", "2356", day);
		p = new CreditCardStrategy("Mario Rossi", "35623522", "2356", day);

		p.pay(new Cart());

	}
	
	@Test
	public void payByPayPalTest() {
		
		PaymentStrategy p = new PaypalStrategy();

		try {

			String s = p.pay(new Cart());

			assertEquals("Paymement done with PayPal: 0.0€.", s);

		} catch (Exception e) {

		}

	}
	
	@Test
	public void payOnDeliveryTest() {
		
		PaymentStrategy p = new PaymentOnDelivery(3);

		try {

			String s = p.pay(new Cart());

			assertEquals("Payment on delivery: 0.0€ plus 3.0€.", s);

		} catch (Exception e) {

		}

	}

}
