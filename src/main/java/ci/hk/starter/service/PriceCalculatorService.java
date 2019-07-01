package ci.hk.starter.service;

import ci.hk.starter.model.Quantity;
import ci.hk.starter.model.SimpleResult;

@FunctionalInterface
public interface PriceCalculatorService {

	SimpleResult calculatePrice(Quantity quantity);
}
