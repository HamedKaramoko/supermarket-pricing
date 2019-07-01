package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.SimpleResult;

/**
 * Decorator used to apply 40% on a product price.
 * 
 * @author hamedkaramoko
 *
 */
public class FourtyPercentDecorator extends PriceCalculatorServiceDecorator {

	public FourtyPercentDecorator(PriceCalculatorService priceCalculatorService) {
		super(priceCalculatorService);
	}
	
	@Override
	public SimpleResult calculatePrice(Quantity quantity) {
		
		if(!(quantity instanceof SimpleQuantity)) {
			throw new IllegalArgumentException("This quantity cannot be applied to this type of Product");
		}
		
		SimpleResult result = priceCalculatorService.calculatePrice(quantity);
		
		
		return new SimpleResult(result.getFinalQuantity(), result.getFinalPrice().multiply(BigDecimal.valueOf(0.6))) ;
	}
	
}
