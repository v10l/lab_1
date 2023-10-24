package com.example.product;
import java.util.Arrays;

public class Product {
    public static void main(String[] args) {
        Food[] breakfast = new Food[20];

        int itemsSoFar = 0;
        boolean countCalories = false;
        boolean doSort = false;

        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (arg.equals("-calories")) {
                    countCalories = true;
                } else if (arg.startsWith("-sort")) {
                    doSort = true;
                }

            } else {
                String[] parts = arg.split("/");
                switch (parts[0]) {
                    case "Cheese" -> breakfast[itemsSoFar] = new Cheese();
                    case "Pie" -> breakfast[itemsSoFar] = new Pie(parts[1]);
                    case "Apple" -> breakfast[itemsSoFar] = new Apple(parts[1]);
                }
                itemsSoFar++;
            }
        }

        int pieSearching = 0;
        Pie pieSearch = new Pie("cherry");
        for (Food pie : breakfast) {
            if (pie instanceof Pie) {
                if ((pie).equals(pieSearch)) {
                    pieSearching++;
                }
            }
        }
        System.out.println("к0личеств0 " + pieSearch + " всег0 " + pieSearching);

        if (countCalories) {
            int sum = 0;
            for (Food item : breakfast) {
                if (item != null) {
                    sum += item.calculateCalories();
                } else break;
            }
            System.out.println("Всег0 кал0рий: " + sum);
        }

        if (doSort) {
            Arrays.sort(breakfast, new FoodComparator());
            for (Food food : breakfast) {
                if (food == null) break;
                food.consume();
            }
        }
    }
}
