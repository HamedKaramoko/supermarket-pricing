package ci.hk.starter.model;

import java.math.BigDecimal;

public class ByWeightProduct implements Product {
	
	/**
	 * Represents the shortest sellable unit price.
	 */
	private static Weight REFERENCE_WEIGHT = Weight.OUNCE;
	
	private String id;
	
	private String name;
	
	/**
	 * Represents the price for the shortest product unit.
	 */
	private BigDecimal unitPrice;
	
	public ByWeightProduct(String id, String name, BigDecimal unitPrice) {
		
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public ByWeightProduct(String id, String name, BigDecimal unitPrice, Weight referenceWeight) {
		
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		
		REFERENCE_WEIGHT = referenceWeight;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public BigDecimal calculatePrice(Quantity quantity) {
		
		WeightQuantity wq = (WeightQuantity) quantity;
		
		return unitPrice.multiply(BigDecimal.valueOf(REFERENCE_WEIGHT.convert(wq.getAmount(), wq.getUnit())));
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
}
