package visitors;

import items.AbstractBundle;
import items.SingleProduct;

public interface ItemVisitor {

	public void visitBundle(AbstractBundle b);

	public void visitSingleProduct(SingleProduct s);

}
