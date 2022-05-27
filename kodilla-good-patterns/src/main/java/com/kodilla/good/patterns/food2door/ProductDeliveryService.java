package com.kodilla.good.patterns.food2door;

public class ProductDeliveryService {

    private FoodProducer foodProducer;

    public ProductDeliveryService(FoodProducer foodProducer) {
        this.foodProducer = foodProducer;
    }

    public void orderProducts() {
        foodProducer.process();
    }
}
