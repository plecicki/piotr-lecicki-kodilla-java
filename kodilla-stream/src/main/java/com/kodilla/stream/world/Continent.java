package com.kodilla.stream.world;

import java.util.Set;

public final class Continent {

    private final Set<Country> countries;
    private final String continentName;

    public Continent(Set<Country> country, String continentName) {
        this.countries = country;
        this.continentName = continentName;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public String getContinentName() {
        return continentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return continentName.equals(continent.continentName);
    }
}
