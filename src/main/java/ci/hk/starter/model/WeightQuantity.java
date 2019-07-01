package ci.hk.starter.model;

public class WeightQuantity implements Quantity {
	
	private double amount;
	
	private Weight unit;
	
	public WeightQuantity(double amount, Weight unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Weight getUnit() {
		return unit;
	}

	public void setUnit(Weight unit) {
		this.unit = unit;
	}
}
