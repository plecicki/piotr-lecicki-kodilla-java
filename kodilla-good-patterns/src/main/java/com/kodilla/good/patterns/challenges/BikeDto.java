package com.kodilla.good.patterns.challenges;

public class BikeDto implements Product{

    private String name;
    private int numberOfItems;
    private char color;
    private String producer;

    public BikeDto(String name, int numberOfItems, char color, String producer) {
        this.name = name;
        this.numberOfItems = numberOfItems;
        this.color = color;
        this.producer = producer;
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

    public char getColor() {
        return color;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nColor: " + color + "\nProducer: " + producer;
    }
}
