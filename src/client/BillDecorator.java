package client;

public class BillDecorator implements Bill {

	private Bill myBill;

	public BillDecorator(Bill bill) {

		this.myBill = bill;

	}

	@Override
	public String printBill(User u) {

		String s = addHeader(u);

		if (this.myBill != null) {

			s = s + this.myBill.printBill(u);

		}

		s = s + addFooter(u);

		return s;

	}

	private String addHeader(User u) {

		String s = " -------- MY SHOP -------- ";

		s = s + "\n";

		s = s + u.getName() + " " + u.getSurname();

		s = s + "\n" + u.getAddress() + "\n";

		return s;
	}

	private String addFooter(User u) {

		String s = "total: " + u.getMyCart().getFinalPrice() + "€. \n";

		s = s + "Thank you.";

		return s;
	}

}
