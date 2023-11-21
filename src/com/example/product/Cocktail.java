package com.example.product;

import java.util.Arrays;

public class Cocktail extends Food implements Nutritious {
    private String filling;

    public Cocktail(String filling1, String filling2) {
        super("К0ктейль");
        this.filling = filling1 + ", " + filling2;
    }

    @Override
    public boolean equals(Object arg0) {

        if (super.equals(arg0)) {
            if (!(arg0 instanceof Cocktail)) return false;
            return filling.equals(((Cocktail) arg0).filling);
        }
        else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + " с0 вкус0м '" + filling.toUpperCase() + "'";
    }

    @Override
    public void consume() {
        System.out.println(this + " выпит");
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling1, String filling2) {
        this.filling = filling1 + ", " + filling2;
    }

    @Override
    public int calculateCalories() {
        int totalCalories = 0;
        String[] flavors = filling.split(", ");
        for (String flavor : flavors) {
            switch (flavor) {
                case "cherry": totalCalories += 228;
                    break;
                case "banana": totalCalories += 337;
                    break;
                case "choco": totalCalories += 111;
                    break;
            }
        }
        return totalCalories;
    }
}
