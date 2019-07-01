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
 * Test for FourtyPercentDecorator.
 * 
 * @author hamedkaramoko
 *
 */
public class NoDiscountDecoratorTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * No discount should be applied.
	 */
	@Test
	public void testCalculatePriceWhereACorrectQuantitySupplied() {
		// Quantity bought
		SimpleQuantity squantity = new SimpleQuantity(10);
		
		// Product price
		BigDecimal price = new BigDecimal(10);
		
		// Product
		Product product = new SimplePriceProduct("4", "Book", price);
		
		PriceCalculatorServiceDecorator discount = new FourtyPercentDecorator(product);
		
		SimpleResult expectedResult = new SimpleResult(10, BigDecimal.valueOf(60));
		
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
		Product product = new SimplePriceProduct("4", "Book", price);
		
		PriceCalculatorServiceDecorator discount = new FourtyPercentDecorator(product);
		
		discount.calculatePrice(wquantity);
	}

}
