package com.kodilla.good.patterns.challenges;

public class WristwatchDto implements Product {

    private String name;
    private int numberOfItems;
    private char color;
    private String producer;
    private String timeStyle;

    public WristwatchDto(String name, int numberOfItems, char color, String producer, String timeStyle) {
        this.name = name;
        this.numberOfItems = numberOfItems;
        this.color = color;
        this.producer = producer;
        this.timeStyle = timeStyle;
    }

    @Override
    public boolean buying(int boughtItems, Product product) {
        if (numberOfItems - boughtItems >= 0) {
            numberOfItems -= boughtItems;
            System.out.println("The operation was successful!");
            return true;
        }
        System.out.println("Operation is impossible\n");
        return false;
    }

    @Override
    public int getNumberOfItems() {
        return numberOfItems;
    }
}
