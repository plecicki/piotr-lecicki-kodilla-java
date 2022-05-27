package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements FoodProducer{

    private int quantity;
    private String product;
    private int deliveryTime;

    public GlutenFreeShop(int quantity, String product, int deliveryTime) {
        this.quantity = quantity;
        this.product = product;
        this.deliveryTime = deliveryTime;
    }

    public boolean process() {
        System.out.println(quantity + " x " + product + " have been ordered");
        System.out.println("The products will be delivered in " + deliveryTime + " days\n");
        return true;
    }
}
