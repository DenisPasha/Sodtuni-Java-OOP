package P05Polymorphism.Exercise.Vehicles;

public abstract class BaseVehicle {

    private double fuelQuantity;
    private double consumption;

    private double tankCapacity;

    public BaseVehicle(double fuelQuantity, double consumption,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public abstract void drive(double distance);
    public abstract void refuel(double litres);

    public String toString(){
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
