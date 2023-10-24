package com.example.product;


public class Cheese extends Food implements Nutritious {
    public Cheese() {
        super("Сыр");
    }

    public void consume() {
        System.out.println(this + " съеден");
    }

    @Override
    public int calculateCalories() {
        return 30;
    }
}
