package client;

import java.util.Iterator;

public class SimpleBill implements Bill {

	@Override
	public String printBill(User u) {

		String s = "";

		Iterator<CartItem> it = u.getMyCart().getIterator();
		CartItem i;
		while (it.hasNext()) {

			i = it.next();
			s = s + i.getItem().getName() + " - " + i.getItem().getDescription();
			s = s + " - x" + i.getQuantity() + " " + i.getItem().getPrice() + "€ \n";

		}
		
		return s;

	}

}
