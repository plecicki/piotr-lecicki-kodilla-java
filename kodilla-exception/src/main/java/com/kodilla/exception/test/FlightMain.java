package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "Not existing Airport");

        FlightSearch flightSearch = new FlightSearch();
        try {
            flightSearch.findFlight(flight);
            System.out.println("Name of typed airport is correct!");
        } catch (RouteNotFoundException e) {
            System.out.println(e);
            System.out.println("Try again!");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
