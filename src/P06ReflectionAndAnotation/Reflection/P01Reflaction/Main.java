package P06ReflectionAndAnotation.Reflection.P01Reflaction;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class reflection = Reflection.class;

        System.out.println(reflection.getSimpleName());
        System.out.println(reflection.getSuperclass().getSimpleName());
        Class[] interfaces = reflection.getInterfaces();
        Arrays.stream(interfaces).forEach(current -> System.out.println(current.getSimpleName()));

        Object object = reflection.getDeclaredConstructor().newInstance();
        System.out.println(object);

    }
}
