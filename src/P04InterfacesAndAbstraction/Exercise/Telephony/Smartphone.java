package P04InterfacesAndAbstraction.Exercise.Telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    //-	numbers: List<String>
    //-	urls: List<String>
    private List<String> numbers;
    private List<String> urls;
    //+	Smartphone(List<String>, List<String>)
    //+	call(): String
    //+	browse(): String

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            boolean isInvalid = false;
            String number = numbers.get(i);
            for (int j = 0; j < number.length(); j++) {
                if (Character.isLetter(number.charAt(j))){
                    isInvalid = true;
                    break;
                }

            }
            if (isInvalid){
                sb.append("Invalid number!").append(System.lineSeparator());
            }else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.urls.size(); i++) {
            String currentUrl = urls.get(i);
            boolean isInvalid = false;
            for (int j = 0; j < currentUrl.length(); j++) {
                if (Character.isDigit(currentUrl.charAt(j))){
                    isInvalid = true;
                    break;
                }

            }
            if (isInvalid){
                sb.append("Invalid URL!").append(System.lineSeparator());
            }else {
                sb.append("Browsing: ").append(currentUrl).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String toString(){
        return String.format("%s%n%s",call(),browse());
    }
}
