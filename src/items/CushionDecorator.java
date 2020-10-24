package items;

public class CushionDecorator extends Sofa {

	private Sofa mySofa;

	private double increment;

	public CushionDecorator(Sofa mySofa) {

		this.mySofa = mySofa;

		this.increment = 15;
	}

	public String getName() {
		return mySofa.getName();
	}

	public double getPrice() {

		return addPrice();
	}

	private double addPrice() {

		return this.mySofa.getPrice() + this.increment;

	}

	public String getDescription() {
		String r = mySofa.getDescription();
		r = addDescription(r);
		return r;
	}

	private String addDescription(String r) {
		return r + " with two cushions";
	}

	public void setDescription(String s) {

		this.mySofa.setDescription(s);

	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}

	public Sofa getMySofa() {
		return mySofa;
	}

	public void setMySofa(Sofa mySofa) {
		this.mySofa = mySofa;
	}

	public Sofa removeCushionsDecorator() throws Exception {

		return this.getMySofa();

	}

}
