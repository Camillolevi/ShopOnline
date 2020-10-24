package items;

public class Table extends Furniture {

	private String name;

	private String description;

	private double price;

	public Table(String name, double price) {

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

}
