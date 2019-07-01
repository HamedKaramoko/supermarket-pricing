package ci.hk.starter.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ci.hk.starter.model.Product;
import ci.hk.starter.model.SimplePriceProduct;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.SimpleResult;
import ci.hk.starter.model.Weight;
import ci.hk.starter.model.WeightQuantity;

/**
 * Test for QuantityFreeForQuantityTakenDecorator.
 * 
 * @author hamedkaramoko
 *
 */
public class QuantityFreeForQuantityTakenDecoratorTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Assumption a sweet cost 0.5 dollar.
	 * 
	 * The offer is 7 sweets bought then 1 sweet given.
	 * If we buy 21 sweets logically we should have 24 sweets for 10.5 dollars.
	 */
	@Test
	public void testCalculatePriceWhereACorrectQuantitySupplied() {
		
		// Quantity bought
		SimpleQuantity squantity = new SimpleQuantity(21);
		
		// Product price
		BigDecimal price = new BigDecimal(0.5);
		
		// Product
		Product product = new SimplePriceProduct("3", "Sweet", price);
		
		PriceCalculatorServiceDecorator discount = new QuantityFreeForQuantityTakenDecorator(7, 1, product);
		
		SimpleResult expectedResult = new SimpleResult(24, BigDecimal.valueOf(10.5));
		
		SimpleResult result = discount.calculatePrice(squantity);
		
		assertThat(result, is(expectedResult));
	}
	
	/**
	 * Test the case where the quantity is not a @{Link SimpleQuantity}.
	 * 
	 */
	@Test(expected= IllegalArgumentException.class)
	public void testCalculatePriceWhereIncorrectQuantitySupplied() {
		
		// Quantity bought
		WeightQuantity wquantity = new WeightQuantity(10, Weight.POUND);
		
		// Product price
		BigDecimal price = new BigDecimal(0.5);
		
		// Product
		Product product = new SimplePriceProduct("3", "Sweet", price);
		
		PriceCalculatorServiceDecorator discount = new QuantityFreeForQuantityTakenDecorator(7, 1, product);
		
		discount.calculatePrice(wquantity);
	}

}
