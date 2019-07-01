package ci.hk.starter.model;

/**
 * Class allowing to keep the amount of a simple product (One product -> one price)
 * 
 * @author hamedkaramoko
 *	
 */
public class SimpleQuantity implements Quantity {
	
	/**
	 * The amount.
	 */
	private int amount;
	
	public SimpleQuantity(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
