package ci.hk.starter.service;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleResult;

public abstract class PriceCalculatorServiceDecorator implements PriceCalculatorService {
	
	protected PriceCalculatorService priceCalculatorService;
	
	public PriceCalculatorServiceDecorator(PriceCalculatorService priceCalculatorService) {
		this.priceCalculatorService = priceCalculatorService;
	}

	@Override
	public SimpleResult calculatePrice(Quantity quantity) {
		
		return priceCalculatorService.calculatePrice(quantity);
	}

}
