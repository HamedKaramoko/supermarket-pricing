package ci.hk.starter.model;

import ci.hk.starter.service.PriceCalculatorService;

public interface Product extends PriceCalculatorService {
	
	String getId();
	
	String getName();
}
