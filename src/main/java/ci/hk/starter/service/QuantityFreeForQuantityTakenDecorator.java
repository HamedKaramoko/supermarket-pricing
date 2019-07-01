package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleQuantity;

public class QuantityFreeForQuantityTakenDecorator extends PriceCalculatorServiceDecorator {
	
	private final int quantityTaken;
	
	private final int quantityFree;
	

	public QuantityFreeForQuantityTakenDecorator(int quantityTaken, int quantityFree, PriceCalculatorService priceCalculatorService) {
		super(priceCalculatorService);
		
		this.quantityTaken = quantityTaken;
		this.quantityFree = quantityFree;
	}
	
	@Override
	public BigDecimal calculatePrice(Quantity quantity) {
		
		if(!(quantity instanceof SimpleQuantity)) {
			throw new IllegalArgumentException("This quantity cannot be applied to this type of Product");
		}
		
		SimpleQuantity sQuantity = (SimpleQuantity) quantity;
		
//		int nbGivingDiscount = sQuantity.getAmount() / quantityTaken ;
		
		return priceCalculatorService.calculatePrice(sQuantity);
	}

}