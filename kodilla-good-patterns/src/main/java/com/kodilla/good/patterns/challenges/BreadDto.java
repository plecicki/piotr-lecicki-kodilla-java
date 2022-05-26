package com.kodilla.good.patterns.challenges;

public class BreadDto implements Product{

    private String name;
    private int numberOfItems;
    private boolean todayBaked;

    public BreadDto(String name, int numberOfItems, boolean todayBaked) {
        this.name = name;
        this.numberOfItems = numberOfItems;
        this.todayBaked = todayBaked;
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
