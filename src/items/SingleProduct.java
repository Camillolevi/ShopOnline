package items;

import visitors.ItemVisitor;

public abstract class SingleProduct implements Item {

	@Override
	public void accept(ItemVisitor v) {

		v.visitSingleProduct(this);

	}

	@Override
	public void add(Item i) throws Exception {

		throw (new Exception("Not allowed operation."));

	}

	@Override
	public void remove(Item i) throws Exception {

		throw (new Exception("Not allowed operation."));

	}

}
