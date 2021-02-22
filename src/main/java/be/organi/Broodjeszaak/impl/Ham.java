package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Beleg;

import javax.persistence.Embeddable;

@Embeddable
public class Ham implements Beleg {

    private final String belegsoort = "Ham";
    private final Double prijs = 0.5;

    @Override
    public String getBelegSoort() {
        return belegsoort;
    }

    @Override
    public Double getBelegPrijs() {
        return prijs;
    }
}
