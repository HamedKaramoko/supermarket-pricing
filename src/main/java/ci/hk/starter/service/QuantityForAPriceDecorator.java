package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.SimpleResult;

public class QuantityForAPriceDecorator extends PriceCalculatorServiceDecorator {
	
	private final BigDecimal discountPrice;
	
	private final int quantityForDiscount;
	

	public QuantityForAPriceDecorator(int quantityForDiscount, BigDecimal discountPrice, PriceCalculatorService priceCalculatorService) {
		super(priceCalculatorService);
		
		this.quantityForDiscount = quantityForDiscount;
		this.discountPrice = discountPrice;
	}
	
	@Override
	public SimpleResult calculatePrice(Quantity quantity) {
		
		if(!(quantity instanceof SimpleQuantity)) {
			throw new IllegalArgumentException("This quantity cannot be applied to this type of Product");
		}
		
		SimpleQuantity sQuantity = (SimpleQuantity) quantity;
		
		int nbWithDiscount = sQuantity.getAmount() / quantityForDiscount ;
		
		int nbWithoutDiscount = sQuantity.getAmount() % quantityForDiscount ;
		
		BigDecimal partWithDiscoutPrice = discountPrice.multiply(BigDecimal.valueOf(nbWithDiscount));
		
		SimpleResult partWithoutDiscoutPrice = priceCalculatorService.calculatePrice(new SimpleQuantity(nbWithoutDiscount));
		
		return new SimpleResult(sQuantity.getAmount(), partWithoutDiscoutPrice.getFinalPrice().add(partWithDiscoutPrice));
	}

}