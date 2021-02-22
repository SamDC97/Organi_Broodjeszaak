package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Brood;

import javax.persistence.Embeddable;

@Embeddable
public class Wit implements Brood {

    private final String broodsoort = "Wit";
    private final double prijs = 2.0;

    @Override
    public String getBroodsoort() {
        return broodsoort;
    }

    @Override
    public Double getBroodPrijs() {
        return prijs;
    }
}
