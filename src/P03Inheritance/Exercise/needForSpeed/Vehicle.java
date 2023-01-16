package P03Inheritance.Exercise.needForSpeed;

public class Vehicle {
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    //•	fuelConsumption – double
    private double fuelConsumption;
    //•	fuel – double
    private double fuel;
    //•	horsePower – int
    private int horsePower;


    //•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    //•	Getters and Setters for the fields

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers){
        if (this.getFuelConsumption() * kilometers <= this.getFuel()){
            double result = this.getFuelConsumption() * kilometers;
            result = getFuel() - result;
            this.setFuel(result);
        }
    }
    //•	void drive(double kilometers)
}
