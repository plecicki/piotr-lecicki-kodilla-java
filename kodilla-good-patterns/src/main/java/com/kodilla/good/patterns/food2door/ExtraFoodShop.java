package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements FoodProducer{

    private int quantity;
    private String product;

    public ExtraFoodShop(int quantity, String product) {
        this.quantity = quantity;
        this.product = product;
    }

    public boolean process() {
        System.out.println(quantity + " x " + product + " have been ordered");
        System.out.println("SMS to client has been sent...\n");
        return true;
    }
}
