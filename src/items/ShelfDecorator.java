package items;

public class ShelfDecorator extends StorageFurnitureDecorator {

	public ShelfDecorator(StorageFurniture myFurniture) {

		super(myFurniture);

		this.setIncrement(20);

	}

	protected String addDescription() {
		return " plus six shelves";
	}

	public StorageFurniture removeDoorDecorator() throws Exception {

		StorageFurniture s = this.getMyFurniture().removeDoorDecorator();
		
		this.setMyFurniture(s);
		
		return this;
		
	}

	public StorageFurniture removeShelfDecorator() throws Exception {

		return this.getMyFurniture();

	}

}
