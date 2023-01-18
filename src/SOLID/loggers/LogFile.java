package SOLID.loggers;

public class LogFile implements File{

    private StringBuilder sb;

    public LogFile() {
        this.sb = new StringBuilder();
    }


    @Override
    public void write(String message) {
        sb.append(message).append(System.lineSeparator());
    }

    @Override
    public int size() {

        int result = sb.chars().filter(e->Character.isAlphabetic(e)).sum();
        return result;
    }
}
