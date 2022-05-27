package com.kodilla.good.patterns.food2door;

public class HealthyShop implements FoodProducer{

    private int quantity;
    private String product;
    private boolean discount;

    public HealthyShop(int quantity, String product, boolean discount) {
        this.quantity = quantity;
        this.product = product;
        this.discount = discount;
    }

    public boolean process() {
        if (discount) {
            System.out.println("Discount accepted");
            System.out.println(quantity + " x " + product + " have been ordered");
        } else {
            System.out.println("You've ordered " + quantity + " x " + product + "without discount");
        }
        System.out.println("SMS to client has been sent...\n");
        return true;
    }
}
