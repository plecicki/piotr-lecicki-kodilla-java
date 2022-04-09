package com.kodilla.testing.shape;

public class Square implements Shape {

    private int sideLength;

    public Square(int sideLength){
        this.sideLength = sideLength;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return (double)(sideLength * sideLength);
    }
}
