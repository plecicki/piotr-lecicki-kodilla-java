package com.kodilla.testing.shape;

public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        return (double)(3.14 * radius * radius);
    }
}
