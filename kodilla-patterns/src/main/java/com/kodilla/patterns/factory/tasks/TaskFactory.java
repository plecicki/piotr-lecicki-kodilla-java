package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Clothes shopping", "Trousers", 2.0);
            case PAINTING:
                return new PaintingTask("Kitchen painting", "Yellow", "Walls in kitchen");
            case DRIVING:
                return new DrivingTask("Trip to America", "New York", "Hyundai");
            default:
                return null;
        }
    }
}
