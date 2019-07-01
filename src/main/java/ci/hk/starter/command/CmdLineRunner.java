package ci.hk.starter.command;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ci.hk.starter.model.ByWeightProduct;
import ci.hk.starter.model.ItemLine;
import ci.hk.starter.model.Product;
import ci.hk.starter.model.SimplePriceProduct;
import ci.hk.starter.model.SimpleQuantity;
import ci.hk.starter.model.SimpleResult;
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
		
		List<ItemLine> items = Arrays.asList(new ItemLine(greenApple, new SimpleQuantity(4)),
				new ItemLine(redApple, new SimpleQuantity(4)),
				new ItemLine(potatoes, new WeightQuantity(4, Weight.OUNCE)));
		
		items.stream()
		.map(item -> getPriceCalculator(item.getProduct()).calculatePrice(item.getQuantity())).forEach(System.out::println);
		
		items.stream()
		.map(item -> getPriceCalculator(item.getProduct()).calculatePrice(item.getQuantity()))
		.map(SimpleResult::getFinalPrice).reduce(BigDecimal::add).ifPresent(finalPrice -> System.out.println("The client bill cost : " + finalPrice + "$"));
		
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
