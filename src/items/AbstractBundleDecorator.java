package items;

import java.util.Iterator;

public abstract class AbstractBundleDecorator extends AbstractBundle {

	private AbstractBundle myBundle;

	private double percent;

	public AbstractBundleDecorator(AbstractBundle b, double percent) {

		this.myBundle = b;

		this.percent = percent;

	}

	public AbstractBundle getMyBundle() {
		return myBundle;
	}

	public void setMyBundle(AbstractBundle myBundle) {
		this.myBundle = myBundle;
	}

	@Override
	public void add(Item i) throws Exception {

		this.myBundle.add(i);

	}

	@Override
	public void remove(Item i) throws Exception {

		this.myBundle.remove(i);

	}

	@Override
	public double getPrice() {

		double p = this.myBundle.getPrice();
		p = getDiscount(p);

		return p;

	}

	protected abstract double getDiscount(double price);

	@Override
	public String getName() {

		return this.myBundle.getName();

	}

	@Override
	public String getDescription() {

		String s = this.myBundle.getDescription();

		s = addDescription(s);

		return s;
	}

	protected abstract String addDescription(String s);

	public void setDescription(String description) {

		this.myBundle.setDescription(description);

	}

	@Override
	public Iterator<Item> getIterator() {

		return this.myBundle.getIterator();

	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

}
