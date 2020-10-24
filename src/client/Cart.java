package client;

import java.util.Iterator;
import java.util.LinkedList;

import discounts.DiscountStrategy;
import items.Item;
import observers.CartObserver;
import observers.ShippingPriceObserver;
import observers.TotalObserver;
import payments.PaymentStrategy;

public class Cart {

	private LinkedList<CartItem> myPurchase;

	private DiscountStrategy myDiscountStrategy;

	private PaymentStrategy myPaymentStrategy;

	private double total;

	private double shippingPrice;

	private LinkedList<CartObserver> myObservers;

	public Cart() {

		this.myPurchase = new LinkedList<CartItem>();

		initMyObservers();

		notifyMyObservers();

	}

	private void initMyObservers() {

		this.myObservers = new LinkedList<CartObserver>();
		new TotalObserver(this);
		new ShippingPriceObserver(this, 1000, 6.5);

	}

	public CartItem findItem(Item item) {

		CartItem res = null;

		Iterator<CartItem> it = this.getIterator();

		CartItem temp;
		while (it.hasNext()) {

			temp = it.next();
			Item i = temp.getItem();
			res = (i.equals(item)) ? temp : res;

		}

		return res;

	}

	public Iterator<CartItem> getIterator() {

		Iterator<CartItem> it = this.myPurchase.iterator();
		return it;

	}

	public void pay(User u){
		
		try {
			this.myPaymentStrategy.pay(this);
		} catch (Exception e) {
			
			System.out.println(e.toString());
			System.out.println("Choose another payment method.");
			
			u.choosePaymentMethod();
			
		}
		
	}

	public void addItem(Item i, int quantity) {

		CartItem ci = this.findItem(i);

		if (ci != null) {

			int q = ci.getQuantity();
			ci.setQuantity(q + quantity);

		} else {

			CartItem anotherCI = new CartItem(i, quantity);
			this.myPurchase.add(anotherCI);

		}

		notifyMyObservers();

	}

	public void removeItem(Item i) throws Exception {

		CartItem ci = findItem(i);

		if (ci != null) {

			this.myPurchase.remove(ci);

		} else {

			throw new Exception("Not existing item.");

		}

		notifyMyObservers();

	}

	public void changeQuantity(Item i, int quantity) {

		CartItem ci = findItem(i);

		if (ci != null) {

			ci.setQuantity(quantity);

			notifyMyObservers();

		}

	}

	public void addObserver(CartObserver o) {

		this.myObservers.add(o);

	}

	public void removeObserver(CartObserver o) {

		this.myObservers.remove(o);

	}

	private void notifyMyObservers() {

		Iterator<CartObserver> it = this.myObservers.iterator();

		while (it.hasNext()) {

			it.next().update(this);

		}

	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double tot) {
		this.total = tot;
	}

	public double getFinalPrice() {

		if (this.myDiscountStrategy != null) {

			return this.myDiscountStrategy.getDiscountedPrice(this);

		} else {

			return this.total;

		}

	}

	public LinkedList<CartItem> getMyPurchase() {
		return myPurchase;
	}

	public DiscountStrategy getMyDiscountStrategy() {
		return myDiscountStrategy;
	}

	public void setMyDiscountStrategy(DiscountStrategy myDiscountStrategy) {
		this.myDiscountStrategy = myDiscountStrategy;
	}

	public PaymentStrategy getMyPaymentStrategy() {
		return myPaymentStrategy;
	}

	public void setMyPaymentStrategy(PaymentStrategy myPaymentStrategy) {
		this.myPaymentStrategy = myPaymentStrategy;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

}
