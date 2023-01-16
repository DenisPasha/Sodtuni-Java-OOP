package P04InterfacesAndAbstraction.lab.BorderControl;

public class Citizen implements Identifiable{

    private String name;
    private int age;
    private String id;

    public int getAge() {
        return age;
    }

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
