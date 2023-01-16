package P04InterfacesAndAbstraction.lab.P03SayHello;

public class Bulgarian implements Person{

    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    //-name: String
    //+sayHello(): String

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
         return "Здравей";
    }
}
