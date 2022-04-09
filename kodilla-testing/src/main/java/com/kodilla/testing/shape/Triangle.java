package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private int baseLength;
    private int height;

    public Triangle(int baseLength, int height) {
        this.baseLength = baseLength;
        this.height = height;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return (double)((1/3) * height * baseLength);
    }

}
