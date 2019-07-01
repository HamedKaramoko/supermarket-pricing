package ci.hk.starter.model;

import java.math.BigDecimal;

public class SimplePriceProduct implements Product {

	private String id;
	
	private String name;
	
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
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
}
