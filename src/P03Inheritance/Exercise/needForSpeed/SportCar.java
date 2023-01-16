package P03Inheritance.Exercise.needForSpeed;

public class SportCar extends Car{
    //•	SportCar – DEFAULT_FUEL_CONSUMPTION = 10
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }


}
