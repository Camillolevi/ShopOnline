package items;

public abstract class StorageFurnitureDecorator extends StorageFurniture {
	
	private StorageFurniture myFurniture;

	private double increment;

	StorageFurnitureDecorator(StorageFurniture myFurniture) {
		
		this.myFurniture = myFurniture;
		
	}

	public String getName() {
		return myFurniture.getName();
	}

	public double getPrice() {
		return this.myFurniture.getPrice() + this.increment;
	}

	public String getDescription() {
		
		String r = this.myFurniture.getDescription();
		
		r = r + addDescription();
		
		return r;

	}

	protected abstract String addDescription();

	public void setDescription(String s){
		
		this.myFurniture.setDescription(s);
		
	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}

	public StorageFurniture getMyFurniture() {
		return myFurniture;
	}

	public void setMyFurniture(StorageFurniture myFurniture) {
		this.myFurniture = myFurniture;
	}

}
