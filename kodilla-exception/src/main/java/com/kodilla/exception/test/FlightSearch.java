package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flights = new HashMap<>();
        flights.put("Warsaw", true);
        flights.put("Poznan", false);
        flights.put("Szczecin", true);
        flights.put("Lublin", false);
        flights.put("Wroclaw", true);
        flights.put("Gdansk", false);
        flights.put("Krakow", true);

        if (flights.containsKey(flight.getArrivalAirport())) {
            if (flights.get(flight.getArrivalAirport())) {
                System.out.println("Flight available :)");
            } else {
                System.out.println("Flight unavailable :(");
            }
        } else {
            throw new RouteNotFoundException("Incorrect name of arrival airport!");
        }
    }
}
