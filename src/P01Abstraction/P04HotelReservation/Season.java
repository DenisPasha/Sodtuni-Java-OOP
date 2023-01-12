package P01Abstraction.P04HotelReservation;

public enum Season {
    Spring(2),
    Autumn(1),
    Winter(3),
    Summer(4);

   private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
