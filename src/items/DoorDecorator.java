package items;

public class DoorDecorator extends StorageFurnitureDecorator {

	public DoorDecorator(StorageFurniture myFurniture) {

		super(myFurniture);

		this.setIncrement(10);

	}

	protected String addDescription() {
		return " plus two doors";
	}

	public StorageFurniture removeDoorDecorator() throws Exception {

		return this.getMyFurniture();

	}

	public StorageFurniture removeShelfDecorator() throws Exception {

		StorageFurniture s = this.getMyFurniture().removeShelfDecorator();
		
		this.setMyFurniture(s);
		
		return this;
	}

}
