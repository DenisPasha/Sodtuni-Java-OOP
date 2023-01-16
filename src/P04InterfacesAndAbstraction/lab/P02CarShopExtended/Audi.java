package P04InterfacesAndAbstraction.lab.P02CarShopExtended;

public class Audi extends CarImpl implements Rentable {

   private int minRentDay;
   private double pricePerDay;
    public Audi(String model, String color, int horsePower, String countryProduced,int minRentDay,double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;

    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString(){
       return String.format( "This is %s produced in %s and have %d tires%n" +
               "Minimum rental period of %d days. Price per day %.2f",this.getModel(),this.countryProduced(),this.TIRES,minRentDay,pricePerDay);
    }
}
