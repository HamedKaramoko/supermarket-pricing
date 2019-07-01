package ci.hk.starter.model;

import ci.hk.starter.service.PriceCalculatorService;

/**
 * Interface representing products.
 * 
 * @author hamedkaramoko
 *
 */
public interface Product extends PriceCalculatorService {
	
	/**
	 * @return the product id.
	 */
	String getId();
	
	/**
	 * @return the product name.
	 */
	String getName();
}
