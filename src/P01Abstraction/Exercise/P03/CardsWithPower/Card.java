package P01Abstraction.Exercise.P03.CardsWithPower;

public class Card {
    private RankPowers powerRank;
    private SuitPowers powerSuit;
    private double power;

    public Card(RankPowers powerRank, SuitPowers powerSuit) {
        this.powerRank = powerRank;
        this.powerSuit = powerSuit;
    }

    public RankPowers getPowerRank() {
        return powerRank;
    }

    public void setPowerRank(RankPowers powerRank) {
        this.powerRank = powerRank;
    }

    public SuitPowers getPowerSuit() {
        return powerSuit;
    }

    public void setPowerSuit(SuitPowers powerSuit) {
        this.powerSuit = powerSuit;
    }

    public double getPower() {
        power = powerSuit.getPower() + powerRank.getPower();
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
