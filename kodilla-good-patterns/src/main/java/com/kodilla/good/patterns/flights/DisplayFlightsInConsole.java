package com.kodilla.good.patterns.flights;

import java.util.Set;

public class DisplayFlightsInConsole {

    private void displayFlightsFromAToB(Set<FlightDto> flightsSet) {
        for (FlightDto flight : flightsSet) {
            System.out.println(flight);
        }
    }

    private void displayFlightsFromAThroughBToC(Set<FlightsThroughAndToDto> flightsSet) {
        for (FlightsThroughAndToDto flights : flightsSet) {
            System.out.println(flights);
        }
    }

    public static void main(String[] args) {

        DisplayFlightsInConsole displayFlightsInConsole = new DisplayFlightsInConsole();
        FlightsDB flightsDB = new FlightsDB();
        flightsDB.fillFlightsDB();
        FindFlight findFlight = new FindFlight(flightsDB.getFlights());

        Set<FlightDto> flightsFromLublin = findFlight.findFlightsFrom("Lublin");
        displayFlightsInConsole.displayFlightsFromAToB(flightsFromLublin);

        System.out.println();

        Set<FlightDto> flightsToGdansk = findFlight.findFlightsTo("Gdansk");
        displayFlightsInConsole.displayFlightsFromAToB(flightsToGdansk);

        System.out.println();

        Set<FlightsThroughAndToDto> flightFromLublinThroughWarsawToWroclaw =
                findFlight.findFlightsThroughXToY("Lublin", "Warsaw", "Wroclaw");
        displayFlightsInConsole.displayFlightsFromAThroughBToC(flightFromLublinThroughWarsawToWroclaw);
    }
}
