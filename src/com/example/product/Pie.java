package com.example.product;

public class Pie extends Food implements Nutritious {
    private String filling;

    public Pie(String filling) {
        super("Пир0г");
        this.filling = filling;
    }

    @Override
    public boolean equals(Object arg0) {

        if (super.equals(arg0)) {
            if (!(arg0 instanceof Pie)) return false; // если принадлежит классу pie
            return filling.equals(((Pie)arg0).filling);
        }
        else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + " начин0чка '" + filling.toUpperCase() + "'";
    }

    @Override
    public void consume() {
            System.out.println(this + " съеден0");
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public int calculateCalories() {
        return switch (filling) {
            case "cherry" -> 228;
            case "strawberry" -> 337;
            case "apple" -> 111;
            default -> 0;
        };
    }
}
