package ci.hk.starter.model;

import java.math.BigDecimal;

import ci.hk.starter.service.PriceCalculatorServiceDecorator;

/**
 * Class representing simple product.
 * 
 * This class should not directly be used by the client.
 * 
 * @see PriceCalculatorServiceDecorator
 * 
 * @author hamedkaramoko
 *
 */
public class SimplePriceProduct implements Product {

	/**
	 * Product id.
	 */
	private String id;
	
	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Represents the price for one unit of the product.
	 */
	private BigDecimal unitPrice;
	
	public SimplePriceProduct(String id, String name, BigDecimal unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
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
		
		SimpleQuantity q = (SimpleQuantity) quantity;
		
		return new SimpleResult(q.getAmount(), unitPrice.multiply( BigDecimal.valueOf(q.getAmount())));
	}
	
	/**
	 * @return the unit price.
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
}
