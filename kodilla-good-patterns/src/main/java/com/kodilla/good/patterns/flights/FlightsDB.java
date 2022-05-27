package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

public class FlightsDB {

    private Set<FlightDto> flights = new HashSet<>();

    public void fillFlightsDB() {
        flights.add(new FlightDto(1 ,"Warsaw", "Lublin"));
        flights.add(new FlightDto(2 ,"Warsaw", "Gdansk"));
        flights.add(new FlightDto(3 ,"Warsaw", "Lodz"));
        flights.add(new FlightDto(4 ,"Warsaw", "Wroclaw"));
        flights.add(new FlightDto(5 ,"Warsaw", "Krakow"));
        flights.add(new FlightDto(6 ,"Lublin", "Warsaw"));
        flights.add(new FlightDto(7 ,"Lublin", "Gdansk"));
        flights.add(new FlightDto(8 ,"Lublin", "Lodz"));
        flights.add(new FlightDto(9 ,"Lublin", "Wroclaw"));
        flights.add(new FlightDto(10 ,"Lublin", "Krakow"));
        flights.add(new FlightDto(11 ,"Gdansk", "Warsaw"));
        flights.add(new FlightDto(12 ,"Gdansk", "Lublin"));
        flights.add(new FlightDto(13 ,"Gdansk", "Lodz"));
        flights.add(new FlightDto(14 ,"Gdansk", "Wroclaw"));
        flights.add(new FlightDto(15 ,"Gdansk", "Krakow"));
        flights.add(new FlightDto(16 ,"Lodz", "Warsaw"));
        flights.add(new FlightDto(17 ,"Lodz", "Lublin"));
        flights.add(new FlightDto(18 ,"Lodz", "Gdansk"));
        flights.add(new FlightDto(19 ,"Lodz", "Wroclaw"));
        flights.add(new FlightDto(20 ,"Lodz", "Krakow"));
        flights.add(new FlightDto(21 ,"Wroclaw", "Warsaw"));
        flights.add(new FlightDto(22 ,"Wroclaw", "Lublin"));
        flights.add(new FlightDto(23 ,"Wroclaw", "Gdansk"));
        flights.add(new FlightDto(24 ,"Wroclaw", "Lodz"));
        flights.add(new FlightDto(25 ,"Wroclaw", "Krakow"));
        flights.add(new FlightDto(26 ,"Krakow", "Warsaw"));
        flights.add(new FlightDto(27 ,"Krakow", "Lublin"));
        flights.add(new FlightDto(28 ,"Krakow", "Gdansk"));
        flights.add(new FlightDto(29 ,"Krakow", "Lodz"));
        flights.add(new FlightDto(30 ,"Krakow", "Wroclaw"));
    }

    public Set<FlightDto> getFlights() {
        return flights;
    }
}
