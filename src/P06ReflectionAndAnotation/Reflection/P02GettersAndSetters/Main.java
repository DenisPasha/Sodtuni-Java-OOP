package P06ReflectionAndAnotation.Reflection.P02GettersAndSetters;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
                Class ogledalo = Reflection.class;

        Arrays.stream(ogledalo.getDeclaredMethods()).
                filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n", method.getName(),method.getReturnType()));

        Arrays.stream(ogledalo.getDeclaredMethods()).
                filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(), Arrays.toString(method.getParameterTypes())));
    }
}
