package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksQueueTestSuite {

    @Test
    public void testUpdate() {
        //Given
        TasksQueue janKowalskiQueue = new TasksQueue("Jan Kowalski");
        TasksQueue piotrNowakQueue = new TasksQueue("Piotr Nowak");
        TasksQueue monikaJavowaQueue = new TasksQueue("Monika Javowa");
        TasksQueue krystynaSpringbootowaQueue = new TasksQueue("Krystyna Springbootowa");
        TasksQueue andrzejHibernateowyQueue = new TasksQueue("Andrzej Hibernateowy");
        Mentor mentor1 = new Mentor("Radoslaw Mazur");
        Mentor mentor2 = new Mentor("Katarzyna Czubowna");
        janKowalskiQueue.registerObserver(mentor1);
        piotrNowakQueue.registerObserver(mentor1);
        monikaJavowaQueue.registerObserver(mentor1);
        krystynaSpringbootowaQueue.registerObserver(mentor2);
        andrzejHibernateowyQueue.registerObserver(mentor2);

        //When
        janKowalskiQueue.addTask(new Task("Add record to database"));
        janKowalskiQueue.addTask(new Task("Connect with external Api"));
        piotrNowakQueue.addTask(new Task("Sort list"));
        monikaJavowaQueue.addTask(new Task("Add background in JavaFX"));
        krystynaSpringbootowaQueue.addTask(new Task("Add button"));
        andrzejHibernateowyQueue.addTask(new Task("Write \"Hello World\" in console"));
        krystynaSpringbootowaQueue.addTask(new Task("Calculator app"));
        janKowalskiQueue.addTask(new Task("First commit using Git"));

        //Then
        Assertions.assertEquals(5, mentor1.getUpdateCount());
        Assertions.assertEquals(3, mentor2.getUpdateCount());
    }
}
