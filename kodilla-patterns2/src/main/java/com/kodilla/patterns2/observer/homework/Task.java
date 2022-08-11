package com.kodilla.patterns2.observer.homework;

public class Task {
    private String name;
    private boolean approved;
    private boolean addedToQueueAndWaitForCheck;
    private int approaches;

    public Task(String name) {
        this.name = name;
        this.approved = false;
        this.addedToQueueAndWaitForCheck = true;
        this.approaches = 1;
    }

    public void sendToChecking() {
        this.addedToQueueAndWaitForCheck = true;
        this.approaches++;
    }

    public void approving() {
        if (this.addedToQueueAndWaitForCheck) {
            this.approved = true;
        }
    }

    public void rejecting() {
        if (this.addedToQueueAndWaitForCheck) {
            this.addedToQueueAndWaitForCheck = false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isAddedToQueueAndWaitForCheck() {
        return addedToQueueAndWaitForCheck;
    }

    public int getApproaches() {
        return approaches;
    }
}
