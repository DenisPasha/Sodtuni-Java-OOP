package P05Polymorphism.Exercise.Vehicles;

import java.text.DecimalFormat;

public class Bus extends BaseVehicle{

    private final static double FULL_BUS_CONSUMPTION_ADDITION = 1.4;


    public Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }

    public void driveFull(double distance){
        this.setConsumption(this.getConsumption() + FULL_BUS_CONSUMPTION_ADDITION);
        drive(distance);

    }

    @Override
    public void drive(double distance) {

            if (distance * this.getConsumption() <= this.getFuelQuantity()){
                double result = this.getFuelQuantity() - (distance * this.getConsumption());
                this.setFuelQuantity(result);
                DecimalFormat decimalFormat = new DecimalFormat("##.##");

                System.out.printf("%s travelled %s km%n",this.getClass().getSimpleName(),decimalFormat.format(distance));
            }else {
                System.out.printf("%s needs refueling%n",this.getClass().getSimpleName());
            }

    }

    @Override
    public void refuel(double litres) {

        if (litres <= 0){
            System.out.println("Fuel must be a positive number");
        }else {
            double result = this.getFuelQuantity() + litres;
            if (result > this.getTankCapacity()){
                System.out.println("Cannot fit fuel in tank");
            }else {
                this.setFuelQuantity(result);
            }
        }
    }
}
