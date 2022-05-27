package com.kodilla.good.patterns.food2door;

public class ProductDeliveryServiceMain {

    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop(3, "Milk");
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(2, "Cheese", 2);
        HealthyShop healthyShop = new HealthyShop(4, "Healthy burger", true);

        ProductDeliveryService productDeliveryService1 = new ProductDeliveryService(extraFoodShop);
        productDeliveryService1.orderProducts();

        ProductDeliveryService productDeliveryService2 = new ProductDeliveryService(glutenFreeShop);
        productDeliveryService2.orderProducts();

        ProductDeliveryService productDeliveryService3 = new ProductDeliveryService(healthyShop);
        productDeliveryService3.orderProducts();
    }
}
