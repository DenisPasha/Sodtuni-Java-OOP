package P01Abstraction.Exercise.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        var torba = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long rocks = 0;
        long money = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long counter = Long.parseLong(safe[i + 1]);

            String item = "";

            if (name.length() == 3) {
                item = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (input < torba.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + counter) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!torba.containsKey(item)) {
                        if (torba.containsKey("Gold")) {
                            if (counter > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(item).values().stream().mapToLong(e -> e).sum() + counter > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!torba.containsKey(item)) {
                        if (torba.containsKey("Gem")) {
                            if (counter > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(item).values().stream().mapToLong(e -> e).sum() + counter > torba.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!torba.containsKey(item)) {
                torba.put((item), new LinkedHashMap<String, Long>());
            }

            if (!torba.get(item).containsKey(name)) {
                torba.get(item).put(name, 0L);
            }


            torba.get(item).put(name, torba.get(item).get(name) + counter);
            if (item.equals("Gold")) {
                gold += counter;
            } else if (item.equals("Gem")) {
                rocks += counter;
            } else if (item.equals("Cash")) {
                money += counter;
            }
        }

        for (var x : torba.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }

    }
}
