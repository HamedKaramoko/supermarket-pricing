package ci.hk.starter.model;

/**
 * Class allowing to keep the amount of weight-products.
 * @author hamedkaramoko
 *
 */
public class WeightQuantity implements Quantity {
	
	/**
	 * The product amount.
	 */
	private double amount;
	
	/**
	 * The amount unit.
	 */
	private Weight unit;
	
	public WeightQuantity(double amount, Weight unit) {
		this.amount = amount;
		this.unit = unit;
	}

	/**
	 * @return the amount.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Set the amount.
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the unit.
	 */
	public Weight getUnit() {
		return unit;
	}

	/**
	 * Set the unit.
	 * 
	 * @param unit
	 */
	public void setUnit(Weight unit) {
		this.unit = unit;
	}
}
