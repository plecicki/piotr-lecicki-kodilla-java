package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING);
        boolean isTaskDoneBefore = shoppingTask.isTaskExecuted();
        shoppingTask.executeTask();
        boolean isTaskDoneAfter = shoppingTask.isTaskExecuted();
        //Then
        Assertions.assertFalse(isTaskDoneBefore);
        Assertions.assertTrue(isTaskDoneAfter);
        Assertions.assertEquals("Clothes shopping", shoppingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING);
        boolean isTaskDoneBefore = paintingTask.isTaskExecuted();
        paintingTask.executeTask();
        boolean isTaskDoneAfter = paintingTask.isTaskExecuted();
        //Then
        Assertions.assertFalse(isTaskDoneBefore);
        Assertions.assertTrue(isTaskDoneAfter);
        Assertions.assertEquals("Kitchen painting", paintingTask.getTaskName());
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING);
        boolean isTaskDoneBefore = drivingTask.isTaskExecuted();
        drivingTask.executeTask();
        boolean isTaskDoneAfter = drivingTask.isTaskExecuted();
        //Then
        Assertions.assertFalse(isTaskDoneBefore);
        Assertions.assertTrue(isTaskDoneAfter);
        Assertions.assertEquals("Trip to America", drivingTask.getTaskName());
    }
}
