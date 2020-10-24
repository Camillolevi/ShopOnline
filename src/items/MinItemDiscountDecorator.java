package items;

import visitors.MinPriceVisitor;

public class MinItemDiscountDecorator extends AbstractBundleDecorator {

	public MinItemDiscountDecorator(AbstractBundle b, double percent) {

		super(b, percent);

	}

	protected String addDescription(String s) {

		return s + " with a discount on the cheaper item by " + (this.getPercent() * 100) + "%.";

	}

	@Override
	protected double getDiscount(double price) {

		MinPriceVisitor v = new MinPriceVisitor();

		double minPrice = v.getMinPrice(this);

		double newMinPrice = minPrice - minPrice * this.getPercent();

		return (price - minPrice + newMinPrice);

	}

	public AbstractBundle removeBundleDecorator() throws Exception {

		AbstractBundle b = this.getMyBundle().removeBundleDecorator();
		
		this.setMyBundle(b);

		return this;
	}

	public AbstractBundle removeDiscountDecorator() throws Exception {

		return this.getMyBundle();

	}

}
