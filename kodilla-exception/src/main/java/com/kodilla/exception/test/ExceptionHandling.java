package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String done = "";
        try {
            done = secondChallenge.probablyIWillThrowException(1, 10);
        } catch (Exception e) {
            done = "Undone!";
        } finally {
            System.out.println(done);
        }
    }
}
