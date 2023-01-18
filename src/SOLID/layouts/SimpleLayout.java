package SOLID.layouts;

public class SimpleLayout implements LayoutService{


    @Override
    public String format(String timeStamp, String reportLevel, String message) {
        return String.format("%s - %s - %s",timeStamp,reportLevel,message);
    }
}
