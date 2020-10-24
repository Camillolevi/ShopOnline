package items;

public class SimpleStorageFurniture extends StorageFurniture {

	private String name;
	private String description;
	private double price;

	public SimpleStorageFurniture(String name, double price) {

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

	public StorageFurniture removeDoorDecorator() throws Exception {

		throw new Exception("Warning!");
	}

	public StorageFurniture removeShelfDecorator() throws Exception {

		throw new Exception("Warning!");
	}

}
