package items;

public abstract class StorageFurniture extends Furniture {

	public StorageFurniture addDoorDecorator() {

		return new DoorDecorator(this);

	}

	public StorageFurniture addShelfDecorator() {

		return new ShelfDecorator(this);

	}

	public abstract StorageFurniture removeDoorDecorator() throws Exception;

	public abstract StorageFurniture removeShelfDecorator() throws Exception;

}
