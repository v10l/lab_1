package com.example.product;

public class Apple extends Food implements Nutritious {
    private String size;

    public Apple(String size) {
        super("Ябл0к0");
        this.size = size;
    }
    @Override
    public void consume() {
        System.out.println(this + " съеден0");
    }

    @Override
    public boolean equals(Object arg0) {

        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false; // если принадлежит классу pie
            return size.equals(((Apple)arg0).size);
        }
        else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + " размер '" + size.toUpperCase() + "'";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public int calculateCalories() {
        return switch (size) {
            case "big" -> 75;
            case "sm0ll" -> 50;
            case "large" -> 100;
            default -> 0;
        };
    }
}
