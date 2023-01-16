package P03Inheritance.Exercise.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private final static double COFFEE_MILLILITERS = 50;
    private final static BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private double caffeine;

    public Coffee(String name, BigDecimal price, double milliliters,double caffeine) {
        super(name, price, milliliters);
        super.setMilliliters(COFFEE_MILLILITERS);
        super.setPrice(COFFEE_PRICE);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
