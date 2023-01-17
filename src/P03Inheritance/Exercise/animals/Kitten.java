package P03Inheritance.Exercise.animals;

public class Kitten extends Cat{
    private final static String GENDER = "Female";
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        super.setGender(GENDER);
    }

    @Override
   public String produceSound(){
       return "Meow";
    }
}
