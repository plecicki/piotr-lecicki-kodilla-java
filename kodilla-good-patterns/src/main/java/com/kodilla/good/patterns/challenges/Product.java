package com.kodilla.good.patterns.challenges;

public interface Product {

    String getName();
    int getNumberOfItems();
    void buying(int boughtItems, Product product);

    default boolean isAvailable() {
        if (getNumberOfItems() >= 1) {
            return true;
        }
        return false;
    };
}
