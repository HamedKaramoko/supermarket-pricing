package ci.hk.starter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * Test price calculation of a weight-product.
 * 
 * @author hamedkaramoko
 *
 */
public class ByWeightProductTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test the case where the product quantity is expressed in POUND and the unit reference in OUNCE.
	 */
	@Test
	public void testCalculatePriceForAProductWhereQuantityInPoundAndReferenceInOunce() {
		
		// Quantity bought
		WeightQuantity wquantity = new WeightQuantity(10, Weight.POUND);
		
		// Product price
		BigDecimal price = new BigDecimal(10.13);
		
		// Product
		Product product = new ByWeightProduct("1", "Banana", price , Weight.OUNCE);
		
		// As the amount bought is in POUND and the unit reference product is OUNCE so it as to be convert into a OUNCE for calculation
		double amountMultiplyByUnit = wquantity.getAmount() * 16;
		
		SimpleResult expectedResult = new SimpleResult(wquantity.getAmount(), price.multiply(BigDecimal.valueOf(amountMultiplyByUnit)));
		SimpleResult result = product.calculatePrice(wquantity);
		
		assertThat(result, is(expectedResult));
	}
	
	/**
	 * Test the case where the product quantity and the unit reference are the same.
	 */
	@Test
	public void testCalculatePriceForAProductWhereQuantityAndUnitReferenceAreSame() {
		
		// Quantity bought
		WeightQuantity wquantity = new WeightQuantity(125, Weight.POUND);
		
		// Product price
		BigDecimal price = new BigDecimal(4);
		
		// Product
		Product product = new ByWeightProduct("1", "Banana", price , Weight.POUND);
		
		SimpleResult expectedResult = new SimpleResult(wquantity.getAmount(), price.multiply(BigDecimal.valueOf(wquantity.getAmount())));
		SimpleResult result = product.calculatePrice(wquantity);
		
		assertThat(result, is(expectedResult));
	}

}
