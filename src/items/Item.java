package items;

import visitors.ItemVisitor;

public interface Item {
	
	public void accept(ItemVisitor v);
	
	public void add(Item i) throws Exception;
	
	public void remove(Item i) throws Exception;
	
	public double getPrice();
	
	public String getName();
	
	public String getDescription();
	
	public void setDescription(String s);

}
