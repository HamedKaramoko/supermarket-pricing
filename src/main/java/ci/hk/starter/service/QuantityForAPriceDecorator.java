package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleQuantity;

public class QuantityForAPriceDecorator extends PriceCalculatorServiceDecorator {
	
	private final BigDecimal discountPrice;
	
	private final int quantityForDiscount;
	

	public QuantityForAPriceDecorator(int quantityForDiscount, BigDecimal discountPrice, PriceCalculatorService priceCalculatorService) {
		super(priceCalculatorService);
		this.quantityForDiscount = quantityForDiscount;
		
		// Immutable pattern
		this.discountPrice = new BigDecimal(0).add(discountPrice);
	}
	
	@Override
	public BigDecimal calculatePrice(Quantity quantity) {
		
		if(!(quantity instanceof SimpleQuantity)) {
			throw new IllegalArgumentException("This quantity cannot be applied to this type of Product");
		}
		
		SimpleQuantity sQuantity = (SimpleQuantity) quantity;
		
		int nbWithDiscount = sQuantity.getAmount() / quantityForDiscount ;
		
		int nbWithoutDiscount = sQuantity.getAmount() % quantityForDiscount ;
		
		BigDecimal b1 = discountPrice.multiply(BigDecimal.valueOf(nbWithDiscount));
		
		BigDecimal b2 = priceCalculatorService.calculatePrice(new SimpleQuantity(nbWithoutDiscount));
		
		return b1.add(b2);
	}

}