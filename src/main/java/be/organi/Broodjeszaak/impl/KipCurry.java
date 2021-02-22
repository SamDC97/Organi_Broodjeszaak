package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Beleg;

import javax.persistence.Embeddable;

@Embeddable
public class KipCurry implements Beleg {

    private final String belegsoort = "Kip-curry";
    private final Double prijs = 0.6;

    @Override
    public String getBelegSoort() {
        return belegsoort;
    }

    @Override
    public Double getBelegPrijs() {
        return prijs;
    }
}
