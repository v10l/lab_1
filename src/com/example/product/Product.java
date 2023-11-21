package com.example.product;
import java.util.Arrays;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
                String className = parts[0];

                try {
                    Class<?> productClass = Class.forName("com.example.product." + className);
                     if (parts.length == 2) {
                        Constructor<?> constructor = productClass.getConstructor(String.class);
                        Object product = constructor.newInstance(parts[1]);
                        breakfast[itemsSoFar] = (Food)product;
                     } else if (parts.length == 3) {
                         Constructor<?> constructor = productClass.getConstructor(String.class, String.class);
                         Object product = constructor.newInstance(parts[1], parts[2]);
                         breakfast[itemsSoFar] = (Food) product;
                     } else {
                         Constructor<?> constructor = productClass.getConstructor();
                         Object product = constructor.newInstance();
                         breakfast[itemsSoFar] = (Food)product;
                     }

                    itemsSoFar++;
                } catch (ClassNotFoundException e) {
                    System.out.println("Пр0дукт " + className + " не найден, п0этому не может быть включен в завтрак");
                } catch (NoSuchMethodException e) {
                    System.out.println("Мет0д пр0дукта " + className + " нет, п0этому не может быть включен в завтрак");
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("0шибка при создании экземпляра пр0дукта " + className);
                }
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
