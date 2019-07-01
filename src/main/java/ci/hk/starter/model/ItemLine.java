package ci.hk.starter.model;

/**
 * Represents a line on the client bill.
 * 
 * @author hamedkaramoko
 *
 */
public class ItemLine {
	
	/**
	 * Represents the product.
	 */
	private Product product;
	
	/**
	 * Represents the product quantity.
	 */
	private Quantity quantity;
	
	public ItemLine(Product product, Quantity quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the product.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the quantity.
	 */
	public Quantity getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity new quantity.
	 */
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

}
