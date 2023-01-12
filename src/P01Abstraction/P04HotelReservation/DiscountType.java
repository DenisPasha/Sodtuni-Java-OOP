package P01Abstraction.P04HotelReservation;

public enum DiscountType {
    None(0),
    SecondVisit(10),
    VIP(20) ;

    private int discountType;

    DiscountType(int discountType) {
        this.discountType = discountType;
    }

    public int getDiscountType() {
        return discountType;
    }
}
