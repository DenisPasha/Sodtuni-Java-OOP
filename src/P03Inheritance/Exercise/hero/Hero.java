package P03Inheritance.Exercise.hero;

public class Hero {

   private String userName;
   private int level;

    public Hero(String userName, int level) {
        this.userName = userName;
        this.level = level;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString(){
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUserName(),
                this.getLevel());

    }
}
