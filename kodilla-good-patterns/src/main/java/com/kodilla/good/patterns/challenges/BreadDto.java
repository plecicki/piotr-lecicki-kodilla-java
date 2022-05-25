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
    public void buying(int boughtItems, Product product) {
        if (numberOfItems - boughtItems >= 0) {
            numberOfItems -= boughtItems;
            System.out.println("The operation was successful!");
            CommunicationWithClient.communicate(product);
        } else {
            System.out.println("Operation is impossible\n");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfItems() {
        return numberOfItems;
    }

    public boolean isTodayBaked() {
        return todayBaked;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nFresh Baked: " + todayBaked;
    }
}
