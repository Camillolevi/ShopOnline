package items;

public class BundleTotDiscountDecorator extends AbstractBundleDecorator {

	public BundleTotDiscountDecorator(AbstractBundle b, double percent) {

		super(b, percent);

	}

	protected String addDescription(String s) {

		return s + " with a discount on the total price by " + (this.getPercent() * 100) + "%.";

	}

	protected double getDiscount(double price) {

		return price - (price * this.getPercent());

	}

	public AbstractBundle removeDiscountDecorator() throws Exception {

		AbstractBundle b = this.getMyBundle().removeDiscountDecorator();

		this.setMyBundle(b);

		return this;
	}

	public AbstractBundle removeBundleDecorator() throws Exception {

		return getMyBundle();

	}

}
