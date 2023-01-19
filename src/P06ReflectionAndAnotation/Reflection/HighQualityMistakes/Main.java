package P06ReflectionAndAnotation.Reflection.HighQualityMistakes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Class ogledalo = Reflection.class;

        //fields
        Arrays.stream(ogledalo.getFields()).forEach(field -> System.out.println(field.getName()+" should be private"));

        System.out.println();
        // get methods
        Arrays.stream(ogledalo.getDeclaredMethods()).filter(method -> method.getName().startsWith("get")).
                filter(method -> !Modifier.isPublic(method.getModifiers())).
                forEach(method -> System.out.println(method.getName() + " should be public"));

        System.out.println();

        //set method
        Arrays.stream(ogledalo.getDeclaredMethods()).filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers())).
                forEach(method -> System.out.println(method.getName()+" should be private"));

    }
}
