package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindFlight {

    private Set<FlightDto> flightSet;

    public FindFlight(Set<FlightDto> flightSet) {
        this.flightSet = flightSet;
    }

    public Set<FlightDto> findFlightsFrom(String cityFrom) {
        Set<FlightDto> foundFlights = flightSet
                .stream()
                .filter(flight -> flight.getFlightFrom() == cityFrom)
                .collect(Collectors.toSet());
        return foundFlights;
    }

    public Set<FlightDto> findFlightsTo(String cityTo) {
        Set<FlightDto> foundFlights = flightSet
                .stream()
                .filter(flight -> flight.getFlightTo() == cityTo)
                .collect(Collectors.toSet());
        return foundFlights;
    }

    public Set<FlightsThroughAndToDto> findFlightsThroughXToY(String cityFrom, String cityThrough, String cityTo) {

        Set<FlightsThroughAndToDto> foundFlightsFinal = new HashSet<>();

        Set<FlightDto> foundFlights1 = flightSet
                .stream()
                .filter(flight -> flight.getFlightFrom() == cityFrom)
                .filter(flight -> flight.getFlightTo() == cityThrough)
                .collect(Collectors.toSet());

        Set<FlightDto> foundFlights2 = flightSet
                .stream()
                .filter(flight -> flight.getFlightFrom() == cityThrough)
                .filter(flight -> flight.getFlightTo() == cityTo)
                .collect(Collectors.toSet());

        for (FlightDto flight1 : foundFlights1) {
            for (FlightDto flight2 : foundFlights2) {
                foundFlightsFinal.add(new FlightsThroughAndToDto(flight1, flight2));
            }
        }

        return foundFlightsFinal;
    }
}
