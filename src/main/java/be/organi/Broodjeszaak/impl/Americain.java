package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Beleg;

import javax.persistence.Embeddable;

@Embeddable
public class Americain implements Beleg {

    private final String belegsoort = "Americain";
    private final Double prijs = 0.7;

    @Override
    public String getBelegSoort() {
        return belegsoort;
    }

    @Override
    public Double getBelegPrijs() {
        return prijs;
    }
}
