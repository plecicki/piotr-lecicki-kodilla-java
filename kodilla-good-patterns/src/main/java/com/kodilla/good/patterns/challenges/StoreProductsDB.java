package com.kodilla.good.patterns.challenges;

public class StoreProductsDB {

    private Product bike1;
    private Product bike2;
    private Product bike3;
    private Product bread1;
    private Product bread2;
    private Product bread3;
    private Product wristwatch1;
    private Product wristwatch2;
    private Product wristwatch3;

    public StoreProductsDB() {
        this.bike1 = new BikeDto("Bike1", 5, 'G', "BikeComp");
        this.bike2 = new BikeDto("Bike2", 3, 'R', "Bikes");
        this.bike3 = new BikeDto("Bike3", 0, 'B', "MountainBikes");
        this.bread1 = new BreadDto("Bread1", 4, true);
        this.bread2 = new BreadDto("Bread2", 3, false);
        this.bread3 = new BreadDto("Bread3", 1, true);
        this.wristwatch1 = new WristwatchDto("Wristwatch1", 4, 'G', "Time", "12h");
        this.wristwatch2 = new WristwatchDto("Wristwatch2", 2, 'B', "Watchmaker", "24h");
        this.wristwatch3 = new WristwatchDto("Wristwatch3", 1, 'Y', "Watches", "12h");
    }

    public Product getBike1() {
        return bike1;
    }

    public Product getBike2() {
        return bike2;
    }

    public Product getBike3() {
        return bike3;
    }

    public Product getBread1() {
        return bread1;
    }

    public Product getBread2() {
        return bread2;
    }

    public Product getBread3() {
        return bread3;
    }

    public Product getWristwatch1() {
        return wristwatch1;
    }

    public Product getWristwatch2() {
        return wristwatch2;
    }

    public Product getWristwatch3() {
        return wristwatch3;
    }
}
