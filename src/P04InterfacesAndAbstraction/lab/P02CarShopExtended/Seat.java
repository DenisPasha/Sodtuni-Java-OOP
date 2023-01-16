package P04InterfacesAndAbstraction.lab.P02CarShopExtended;

public class Seat extends CarImpl implements Sellable{
    private double getPrice;
    public Seat(String model, String color, int horsePower, String countryProduced,double getPrice) {
        super(model, color, horsePower, countryProduced);
        this.getPrice = getPrice;
    }

    @Override
    public double getPrice() {
        return getPrice;
    }
    public String toString(){
        return String.format("This is %s produced in %s and have %d tires%n" +
                "%s sells for %.2f",this.getModel(),this.countryProduced(),this.TIRES,this.getModel(),getPrice);
    }
}
