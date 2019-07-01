package ci.hk.starter.service;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.SimpleResult;

/**
 * If you take a certain amount of article you earn an certain amount for free.
 * 
 * For instance if you take two items you get one for free.
 * 
 * @author hamedkaramoko
 *
 */
public class QuantityFreeForQuantityTakenDecorator extends PriceCalculatorServiceDecorator {
	
	/**
	 * Represents the amount of item to take in order to have a quantity of free item.
	 */
	private final int quantityTaken;
	
	/**
	 * Represents the amount of free items earn when we buy a certain quantity of item.
	 */
	private final int quantityFree;
	

	public QuantityFreeForQuantityTakenDecorator(int quantityTaken, int quantityFree, PriceCalculatorService priceCalculatorService) {
		super(priceCalculatorService);
		
		this.quantityTaken = quantityTaken;
		this.quantityFree = quantityFree;
	}
	
	@Override
	public SimpleResult calculatePrice(Quantity quantity) {
		
		if(!(quantity instanceof SimpleQuantity)) {
			throw new IllegalArgumentException("This quantity cannot be applied to this type of Product");
		}
		
		SimpleQuantity sQuantity = (SimpleQuantity) quantity;
		
		int nbGivingDiscount = sQuantity.getAmount() / quantityTaken ;
		
		SimpleResult finalPriceToPay = priceCalculatorService.calculatePrice(sQuantity);
		
		return new SimpleResult(sQuantity.getAmount() + (nbGivingDiscount * quantityFree), finalPriceToPay.getFinalPrice());
	}

}