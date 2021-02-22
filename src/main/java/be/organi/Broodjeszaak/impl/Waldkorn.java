package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Brood;

import javax.persistence.Embeddable;

@Embeddable
public class Waldkorn implements Brood {

    private final String broodsoort = "Waldkorn";
    private final Double prijs = 2.2;

    @Override
    public String getBroodsoort() {
        return broodsoort;
    }

    @Override
    public Double getBroodPrijs() {
        return prijs;
    }
}
