package ci.hk.starter.service;

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
	
}
