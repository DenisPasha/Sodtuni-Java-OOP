package P01Abstraction.lab.P04HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay, int numOfDays, Season currentSeason, DiscountType discountType){
        double price = pricePerDay * numOfDays;
        price = price * currentSeason.getMultiplier();
        price = price * (100 - discountType.getDiscountType()) /100;
        return price;
    }

}
