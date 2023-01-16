package P03Inheritance.Exercise.restaurant;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    //HotBeverage and ColdBeverage are beverages and they accept the following parameters upon initialization:
    // String name, BigDecimal price, double milliliters

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
