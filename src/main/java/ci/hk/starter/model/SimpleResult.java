package ci.hk.starter.model;

import java.math.BigDecimal;

public class SimpleResult {
	
	private double finalQuantity;
	
	private BigDecimal finalPrice;
	
	public SimpleResult(double finalQuantity, BigDecimal finalPrice) {
		this.finalQuantity = finalQuantity;
		this.finalPrice = finalPrice;
	}

	public double getFinalQuantity() {
		return finalQuantity;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}
	
	@Override
	public String toString() {
		return String.format("SimpleResult - [finalQuantity : %s] - [finalPrice : %s$]", finalQuantity, finalPrice);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalPrice == null) ? 0 : finalPrice.hashCode());
		long temp;
		temp = Double.doubleToLongBits(finalQuantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleResult other = (SimpleResult) obj;
		if (finalPrice == null) {
			if (other.finalPrice != null)
				return false;
		} else if (!finalPrice.equals(other.finalPrice))
			return false;
		if (Double.doubleToLongBits(finalQuantity) != Double.doubleToLongBits(other.finalQuantity))
			return false;
		return true;
	}

}
