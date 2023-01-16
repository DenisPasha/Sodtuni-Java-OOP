package P04InterfacesAndAbstraction.lab.P04SayHelloExtended;

public class European extends BasePerson{
    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
