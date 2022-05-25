package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public static void main(String[] args) {
        StoreProductsDB storeProductsDB = new StoreProductsDB();
        if (storeProductsDB.getBike1().isAvailable()) {
            storeProductsDB.getBike1().buying(1, storeProductsDB.getBike1());
        }
        if (storeProductsDB.getBike2().isAvailable()) {
            storeProductsDB.getBike2().buying(4, storeProductsDB.getBike2());
        }
        if (storeProductsDB.getBike3().isAvailable()) {
            storeProductsDB.getBike3().buying(2, storeProductsDB.getBike3());
        }
        if (storeProductsDB.getBread1().isAvailable()) {
            storeProductsDB.getBread1().buying(3, storeProductsDB.getBread1());
        }
        if (storeProductsDB.getWristwatch2().isAvailable()) {
            storeProductsDB.getWristwatch2().buying(2, storeProductsDB.getWristwatch2());
        }
    }
}
