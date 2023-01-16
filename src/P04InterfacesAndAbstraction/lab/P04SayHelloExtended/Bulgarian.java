package P04InterfacesAndAbstraction.lab.P04SayHelloExtended;

public class Bulgarian extends BasePerson{
    protected Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Zdravey";
    }
}
