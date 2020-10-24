package payments;

import java.util.Calendar;

import client.Cart;

public class CreditCardStrategy implements PaymentStrategy {

	private String name;

	private String cardNumber;

	private String cvv;

	private Calendar dateOfExpiry;

	public CreditCardStrategy(String name, String cardNumber, String cvv, Calendar dateOfExpiry) {

		this.name = name;

		this.cardNumber = cardNumber;

		this.cvv = cvv;

		this.dateOfExpiry = dateOfExpiry;

	}

	public String pay(Cart c) throws Exception {

		Calendar today = Calendar.getInstance();

		if (dateOfExpiry.before(today)) {

			throw new Exception("Expired Credit Card");

		}

		return "Paymement done with credit card: " + c.getFinalPrice() + "€.";

	}

	public Calendar getDateOfExpiry() {

		return dateOfExpiry;

	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

}
