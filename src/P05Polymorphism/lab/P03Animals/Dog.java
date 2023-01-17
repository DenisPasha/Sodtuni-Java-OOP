package P05Polymorphism.lab.P03Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }


    @Override
    public String explainSelf() {
        return "DJAAF";
    }
}
