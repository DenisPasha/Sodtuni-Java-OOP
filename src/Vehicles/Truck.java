package Vehicles;

import java.text.DecimalFormat;

public class Truck extends BaseVehicle{

    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption);
        super.setConsumption(this.getConsumption() + FUEL_CONSUMPTION_INCREASE);
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
        double result = this.getFuelQuantity() + litres * 0.95;
        this.setFuelQuantity(result);

    }
}
