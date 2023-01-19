package P06ReflectionAndAnotation.Reflection.Exercises.harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();
		Class reflection = RichSoilLand.class;
		String wantedFields = "";

		while (!command.equals("HARVEST")){

			switch (command){
				case "private":
					wantedFields = "private";
					getFields(reflection,wantedFields);
					break;
				case "public":
					wantedFields = "public";
					getFields(reflection,wantedFields);
					break;
				case "protected":
					wantedFields = "protected";
					getFields(reflection,wantedFields);
					break;
				case "all":
					Arrays.stream(reflection.getDeclaredFields()).forEach(field -> System.out.printf("%s %s %s%n",
							Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
					break;
			}


			command = scanner.nextLine();
		}
	}

	private static void getFields(Class reflection, String wantedFields) {
		Arrays.stream(reflection.getDeclaredFields()).filter(field -> Modifier.toString(field.getModifiers()).equals(wantedFields))
				.forEach(field -> System.out.printf("%s %s %s%n"
						,Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
	}
}
