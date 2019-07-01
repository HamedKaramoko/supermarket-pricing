package ci.hk.starter.service;

import java.math.BigDecimal;

import ci.hk.starter.model.Quantity;

@FunctionalInterface
public interface PriceCalculatorService {

	BigDecimal calculatePrice(Quantity quantity);
}
