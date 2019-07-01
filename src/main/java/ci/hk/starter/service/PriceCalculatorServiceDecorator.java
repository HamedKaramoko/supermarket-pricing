package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;

public abstract class PriceCalculatorServiceDecorator implements PriceCalculatorService {
	
	protected PriceCalculatorService priceCalculatorService;
	
	public PriceCalculatorServiceDecorator(PriceCalculatorService priceCalculatorService) {
		this.priceCalculatorService = priceCalculatorService;
	}

	@Override
	public BigDecimal calculatePrice(Quantity quantity) {
		
		return priceCalculatorService.calculatePrice(quantity);
	}

}
