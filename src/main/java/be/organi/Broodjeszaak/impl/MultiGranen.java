package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Brood;

import javax.persistence.Embeddable;

@Embeddable
public class MultiGranen implements Brood {

    private final String broodsoort = "Multi-granen";
    private final Double prijs = 2.3;

    @Override
    public String getBroodsoort() {
        return broodsoort;
    }

    @Override
    public Double getBroodPrijs() {
        return prijs;
    }
}
