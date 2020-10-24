package items;

public class Appliance extends SingleProduct {

	private int garantee;
	private double price;
	private String name;
	private String description;

	public Appliance(String name, double price, int garantee) {
		
		this.price = price;

		this.garantee = garantee;

		this.name = name;

		this.description = "Default description";

	}

	public int getGarantee() {

		return garantee;

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

}
