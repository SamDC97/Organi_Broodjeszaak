package be.organi.Broodjeszaak.domain;

import be.organi.Broodjeszaak.impl.*;
import be.organi.Broodjeszaak.interfaces.Beleg;
import org.springframework.stereotype.Component;

@Component
public class BelegFactory {

    public Beleg create(String naam) {
        switch (naam){
            case "Kaas": return new Kaas();
            case "Ham": return new Ham();
            case "Kip-curry": return new KipCurry();
            case "Americain": return new Americain();
            case "Krabsla": return new Krabsla();
            case "Gebakken kip": return new GebakkenKip();
            default: throw new IllegalArgumentException("Geen geldig beleg gevonden voor " + naam);
        }
    }
}
