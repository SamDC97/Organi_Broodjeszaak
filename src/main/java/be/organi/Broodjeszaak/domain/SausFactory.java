package be.organi.Broodjeszaak.domain;

import be.organi.Broodjeszaak.impl.*;
import be.organi.Broodjeszaak.interfaces.Saus;
import org.springframework.stereotype.Component;

@Component
public class SausFactory {

    public Saus create(String naam) {
        switch (naam){
            case "Mayonaise": return new Mayonaise();
            case "Ketchup": return new Ketchup();
            case "Pepersaus": return new Pepersaus();
            case "Andalouse": return new Andalouse();
            case "Cocktail": return new Cocktail();
            default: return null;
        }
    }
}
