package P03Inheritance.Exercise.needForSpeed;

public class RaceMotorcycle extends Motorcycle {

    //•	RaceMotorcycle – DEFAULT_FUEL_CONSUMPTION = 8
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
