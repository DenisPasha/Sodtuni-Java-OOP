package P03Inheritance.Exercise.needForSpeed;

public class Car extends Vehicle{
    //•	Car – DEFAULT_FUEL_CONSUMPTION = 3
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
