package ci.hk.starter.model;

public class SimpleResult {
	
	private double finalQuantity;
	
	private double finalPrice;
	
	public SimpleResult(double finalQuantity, double finalPrice) {
		this.finalQuantity = finalQuantity;
		this.finalPrice = finalPrice;
	}

	public double getFinalQuantity() {
		return finalQuantity;
	}

	public double getFinalPrice() {
		return finalPrice;
	}
	
	@Override
	public String toString() {
		return String.format("SimpleResult - [finalQuantity : %s] - [finalPrice : %s$]", finalQuantity, finalPrice);
	}
}
