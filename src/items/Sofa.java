package items;

public abstract class Sofa extends Furniture {
	
	public Sofa addCushionsDecorator(){
		
		 return new CushionDecorator(this);
		
	}
	
	public abstract Sofa removeCushionsDecorator() throws Exception;


}
