package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Set<Country> countriesAsia = new HashSet<>();
        countriesAsia.add(new Country("China", new BigDecimal("12345000")));
        countriesAsia.add(new Country("Japan", new BigDecimal("100000000")));
        countriesAsia.add(new Country("Indonesia", new BigDecimal("200000000")));
        Set<Country> countriesEurope = new HashSet<>();
        countriesEurope.add(new Country("Poland", new BigDecimal("38000000")));
        countriesEurope.add(new Country("Germany", new BigDecimal("50000000")));
        countriesEurope.add(new Country("France", new BigDecimal("100000000")));
        Set<Country> countriesAfrica = new HashSet<>();
        countriesAfrica.add(new Country("Senegal", new BigDecimal("1000000")));
        countriesAfrica.add(new Country("Kenia", new BigDecimal("200000")));
        countriesAfrica.add(new Country("Uganda", new BigDecimal("450000000")));

        Continent asia = new Continent(countriesAsia, "Asia");
        Continent europe = new Continent(countriesEurope, "Europe");
        Continent africa = new Continent(countriesAfrica, "Africa");

        Set<Continent> continentsSet = new HashSet<>();
        continentsSet.add(asia);
        continentsSet.add(europe);
        continentsSet.add(africa);
        World world = new World(continentsSet);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("951545000");
        assertEquals(expectedPeople, totalPeople);
    }

}
