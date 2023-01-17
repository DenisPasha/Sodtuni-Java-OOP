package P03Inheritance.Exercise.animals;

public class Tomcat extends Cat{
    private final static String GENDER = "Male";
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
        super.setGender(GENDER);
    }

    @Override
    public String produceSound(){
     return "MEOW";
    }
}
