package ci.hk.starter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * Test price calculation of a simple product.
 * 
 * @author hamedkaramoko
 *
 */
public class SimpleProductTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test the price calculation for a simple Product.
	 */
	@Test
	public void testCalculatePriceForAProductWhereQuantityInPoundAndReferenceInOunce() {
		
		// Quantity bought
		SimpleQuantity squantity = new SimpleQuantity(45);
		
		// Product price
		BigDecimal price = new BigDecimal(10.13);
		
		// Product
		Product product = new SimplePriceProduct("2", "Plate", price);
		
		
		SimpleResult expectedResult = new SimpleResult(squantity.getAmount(), price.multiply(BigDecimal.valueOf(squantity.getAmount())));
		SimpleResult result = product.calculatePrice(squantity);
		
		assertThat(result, is(expectedResult));
	}

}
