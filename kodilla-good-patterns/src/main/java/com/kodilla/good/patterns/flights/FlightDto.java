package com.kodilla.good.patterns.flights;

public class FlightDto {

    private int flightID;
    private String flightFrom;
    private String flightTo;

    public FlightDto(int flightID, String flightFrom, String flightTo) {
        this.flightID = flightID;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDto flight = (FlightDto) o;

        return flightID == flight.flightID;
    }

    @Override
    public int hashCode() {
        return flightID / 10;
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightID + " from " + flightFrom + " to " + flightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }
}
