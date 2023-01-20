package P06ReflectionAndAnotation.Reflection.Exercises.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class reflection = BlackBoxInt.class;

       Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
       constructor.setAccessible(true);
        Object objectOfReflection = constructor.newInstance();

        String command = scanner.nextLine();
        List<Field> fieldList = Arrays.stream(reflection.getDeclaredFields()).
                filter(field -> field.getName().equals("innerValue")).limit(1).collect(Collectors.toList());

        Field innerValue = fieldList.get(0);
        innerValue.setAccessible(true);

        while (!command.equals("END")){

            String methodName = command.split("_")[0];
            int  number = Integer.parseInt(command.split("_")[1]);

            switch (methodName){
                case "add":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
                case "subtract":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
                case "divide":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
                case "multiply":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
                case "rightShift":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
                case "leftShift":
                    printInnerValue(reflection, objectOfReflection, innerValue, methodName, number);
                    break;
            }


            command = scanner.nextLine();
        }




    }

    private static void printInnerValue(Class reflection, Object objectOfReflection, Field innerValue, String methodName, int number) throws IllegalAccessException, InvocationTargetException {
        Method add = null;

        add = getMethod(reflection, methodName);
        add.setAccessible(true);
        add.invoke(objectOfReflection, number);
        System.out.println(innerValue.get(objectOfReflection));
    }

    private static Method getMethod(Class reflection, String wantedMethod) {
        List<Method>methodList = List.of(reflection.getDeclaredMethods());
        Method methodToReturn=null;
        for (int i = 0; i < methodList.size(); i++) {
            if (methodList.get(i).getName().equals(wantedMethod)){
                methodToReturn = methodList.get(i);
            }
        }
        return methodToReturn;
    }
}
