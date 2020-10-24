package items;

public class SimpleSofa extends Sofa {

	private String name;

	private String description;

	private double price;

	public SimpleSofa(String name, double price) {

		this.name = name;

		this.price = price;

		this.description = "Default description";
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {

		this.description = description;

	}

	public Sofa removeCushionsDecorator() throws Exception {
		
		throw new Exception("Warning!");
	
	}

}
