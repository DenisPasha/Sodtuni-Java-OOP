package P04InterfacesAndAbstraction.lab.P04SayHelloExtended;

public class Chinese extends BasePerson{
    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "dakajd";
    }
}
