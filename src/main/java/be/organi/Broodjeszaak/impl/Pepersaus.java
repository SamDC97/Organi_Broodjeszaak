package be.organi.Broodjeszaak.impl;

import be.organi.Broodjeszaak.interfaces.Saus;

import javax.persistence.Embeddable;

@Embeddable
public class Pepersaus implements Saus {

    private final String sausSoort = "Pepersaus";
    private final Double prijs = 0.3;

    @Override
    public String getSausSoort() {
        return sausSoort;
    }

    @Override
    public Double getSausPrijs() {
        return prijs;
    }
}
