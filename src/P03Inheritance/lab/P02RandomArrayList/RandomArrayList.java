package P03Inheritance.lab.P02RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement(){
        Random random = new Random();
        int index = random.nextInt(super.size());
       return super.remove(index);

    }
}
