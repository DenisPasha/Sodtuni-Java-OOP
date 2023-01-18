package SOLID.layouts;

public class XmlLayout implements LayoutService{


    @Override
    public String format(String timeStamp, String reportLevel, String message) {
        return String.format("<log>%n" +
                    "<date>%s</date>%n" +
                     "<level>%s</level>%n" +
                    "<message>$s</message>%n" +
                "</log>%n",timeStamp,reportLevel,message);
    }
}
