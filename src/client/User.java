package client;

import managament.IdManager;

public class User {

	private final int id;

	private String name;

	private String surname;

	private String address;

	private int birthday;

	private Cart myCart;

	private Card myCard;

	private Bill myBill;

	public User(String name, String surname, String address, int birthday) {

		this.id = IdManager.getUserID();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.birthday = birthday;
		this.myCart = new Cart();
		this.myBill = new BillDecorator(new SimpleBill());

	}

	public void assignCard() {

		this.myCard = new Card();

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public Cart getMyCart() {
		return myCart;
	}

	public int getId() {
		return id;
	}

	public int getBirthday() {
		return birthday;
	}

	public Card getMyCard() {
		return myCard;
	}

	public Bill getMyBill() {
		return myBill;
	}

	public void buy() {

		String s = this.myBill.printBill(this);
		System.out.println(s);

		choosePaymentMethod();

		myCart.pay(this);

	}

	public void choosePaymentMethod() {

		// PaymentStrategy paymentStrategy = scelta da interfaccia
		// this.myCart.setMyPaymentStrategy(paymentStrategy);

	}

}
