package ci.hk.starter.model;

/**
 * @author hamedkaramoko
 *
 *	Allow to keep the amount of a simple product (One product -> one price)
 */
public class SimpleQuantity implements Quantity {
	
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
