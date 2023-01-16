package P04InterfacesAndAbstraction.Exercise.FoodShortage;

public class Citizen implements Person, Identifiable, Birthable,Buyer {
    private String name;
    private int age;

    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age,String id,String birtDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birtDate;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void buyFood() {
         this.food = this.food + 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
