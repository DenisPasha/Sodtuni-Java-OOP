package P03Inheritance.lab.P03Stack;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }
    //•	Public method: pop(): String
    public String pop(){
       return this.data.remove(this.data.size()-1);
    }
    //•	Public method: peek(): String
    public String peek(){
        return this.data.get(this.data.size()-1);
    }
    //•	Public method: isEmpty(): boolean
    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}