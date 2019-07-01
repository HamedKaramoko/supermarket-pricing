package ci.hk.starter.model;

public class SimpleResult implements Result {
	
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
}
