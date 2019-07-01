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
 * Test for QuantityForAPriceDecorator.
 * 
 * @author hamedkaramoko
 *
 */
public class QuantityForAPriceDecoratorTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * The offer is 3 plates for 20 dollars instead of 30 dollars.
	 * If we buy 5 plates logically we should have 5 plates for 40 dollars.
	 */
	@Test
	public void testCalculatePriceWhereACorrectQuantitySupplied() {
		// Quantity bought
		SimpleQuantity squantity = new SimpleQuantity(5);
		
		// Product price
		BigDecimal price = new BigDecimal(10);
		
		// Product
		Product product = new SimplePriceProduct("2", "Plate", price);
		
		PriceCalculatorServiceDecorator discount = new QuantityForAPriceDecorator(3, BigDecimal.valueOf(20), product);
		
		SimpleResult expectedResult = new SimpleResult(5, BigDecimal.valueOf(40));
		
		SimpleResult result = discount.calculatePrice(squantity);
		
		assertThat(result, is(expectedResult));
	}
	
	/**
	 * Test the case where the quantity is not a @{Link SimpleQuantity}.
	 */
	@Test(expected= IllegalArgumentException.class)
	public void testCalculatePriceWhereIncorrectQuantitySupplied() {
		
		// Quantity bought
		WeightQuantity wquantity = new WeightQuantity(10, Weight.POUND);
		
		// Product price
		BigDecimal price = new BigDecimal(10);
		
		// Product
		Product product = new SimplePriceProduct("2", "Plate", price);
		
		PriceCalculatorServiceDecorator discount = new QuantityForAPriceDecorator(3, BigDecimal.valueOf(20), product);
		
		discount.calculatePrice(wquantity);
	}

}
