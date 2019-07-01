package ci.hk.starter.model;

import java.math.BigDecimal;

import ci.hk.starter.service.PriceCalculatorServiceDecorator;

/**
 * Class representing product with a weight.
 * 
 * This class should not directly be used by the client.
 * 
 * @see PriceCalculatorServiceDecorator
 * 
 * @author hamedkaramoko
 *
 */
public class ByWeightProduct implements Product {
	
	/**
	 * Represents reference unit.
	 */
	private static Weight REFERENCE_WEIGHT = Weight.OUNCE;
	
	/**
	 * Product id.
	 */
	private String id;
	
	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Represents the price for the reference unit.
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
	public SimpleResult calculatePrice(Quantity quantity) {
		
		WeightQuantity wq = (WeightQuantity) quantity;
		
		BigDecimal quantityBD = BigDecimal.valueOf(REFERENCE_WEIGHT.convert(wq.getAmount(), wq.getUnit()));
		
		return new SimpleResult(wq.getAmount(),	unitPrice.multiply(quantityBD));
	}

	/**
	 * @return the unit price.
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
}
