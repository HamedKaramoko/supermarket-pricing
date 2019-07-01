package ci.hk.starter.command;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Function;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ci.hk.starter.model.ByWeightProduct;
import ci.hk.starter.model.ItemLine;
import ci.hk.starter.model.Product;
import ci.hk.starter.model.SimplePriceProduct;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.Weight;
import ci.hk.starter.model.WeightQuantity;
import ci.hk.starter.service.PriceCalculatorService;
import ci.hk.starter.service.QuantityForAPriceDecorator;
import ci.hk.starter.service.QuantityFreeForQuantityTakenDecorator;

@Component
public class CmdLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		Product greenApple = new SimplePriceProduct("GreenApple#000009", "Green apple", BigDecimal.valueOf(4));
		
		Product redApple = new SimplePriceProduct("RedApple#000033", "Red apple", BigDecimal.valueOf(7));
		
		Product potatoes = new ByWeightProduct("Potatoes#250009", "Potatoes", BigDecimal.valueOf(1.99), Weight.POUND);
		
		List<Product> products = Arrays.asList(greenApple, redApple, potatoes);
		
		
		List<ItemLine> items = Arrays.asList(new ItemLine(greenApple, new SimpleQuantity(4)),
				new ItemLine(redApple, new SimpleQuantity(4)),
				new ItemLine(potatoes, new WeightQuantity(4, Weight.OUNCE)));
		
		
		DoubleSummaryStatistics finalResult = items.stream()
		.map((Function<ItemLine, BigDecimal>)item -> getPriceCalculator(item.getProduct()).calculatePrice(item.getQuantity()))
		.mapToDouble(linePrice -> linePrice.doubleValue()).summaryStatistics();
		
		System.out.println("The client bill cost : " + finalResult.getSum());
		
		
//		PriceCalculatorService appleWithoutDiscount = redApple;
//		
//		
//		System.out.println("Without discount : " + appleWithoutDiscount.calculatePrice(quantity));
//		
//		System.out.println("With discount : " + appleWithDiscount.calculatePrice(quantity));
//		
//		
//		
//		
//		Quantity wquantity = new WeightQuantity(4, Weight.OUNCE);
//		
//		System.out.println("By weight product without discount : " + potatoes.calculatePrice(wquantity));

	}
	
	public PriceCalculatorService getPriceCalculator(Product product) {
		
		PriceCalculatorService calculator = product;
		
		switch(product.getId()) {
		
			case "GreenApple#000009" :
				
				calculator = new QuantityForAPriceDecorator(3, new BigDecimal(1), product);
				break;
				
			case "RedApple#000033" :
				calculator = new QuantityFreeForQuantityTakenDecorator(2, 1, product);
		}
		
		return calculator;
	}

}
