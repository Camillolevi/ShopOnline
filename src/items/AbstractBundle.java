package items;

import java.util.Iterator;

import visitors.ItemVisitor;

public abstract class AbstractBundle implements Item {

	@Override
	public void accept(ItemVisitor v) {

		v.visitBundle(this);

	}

	public abstract Iterator<Item> getIterator();
	
	public AbstractBundle addDiscountDecorator(double percent){
		
		 return new MinItemDiscountDecorator(this, percent);
		
	}
	
	public AbstractBundle addBundleDecorator(double percent){
		
		 return new BundleTotDiscountDecorator(this, percent);
		
	}
	
	public abstract AbstractBundle removeDiscountDecorator() throws Exception;
	
	public abstract AbstractBundle removeBundleDecorator() throws Exception;



}