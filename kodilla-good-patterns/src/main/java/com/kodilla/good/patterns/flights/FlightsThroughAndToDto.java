package com.kodilla.good.patterns.flights;

public class FlightsThroughAndToDto {

    private FlightDto firstFlight;
    private FlightDto secondFlight;

    public FlightsThroughAndToDto(FlightDto firstFlight, FlightDto secondFlight) {
        this.firstFlight = firstFlight;
        this.secondFlight = secondFlight;
    }

    @Override
    public String toString() {
        return "First: " + firstFlight + "\nSecond: " + secondFlight;
    }
}
