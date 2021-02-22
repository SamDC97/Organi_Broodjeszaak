package be.organi.Broodjeszaak.domain;

import be.organi.Broodjeszaak.impl.Bruin;
import be.organi.Broodjeszaak.impl.MultiGranen;
import be.organi.Broodjeszaak.impl.Waldkorn;
import be.organi.Broodjeszaak.impl.Wit;
import be.organi.Broodjeszaak.interfaces.Brood;
import org.springframework.stereotype.Component;

@Component
public class BroodFactory {

    public Brood create(String naam) {
        switch (naam){
            case "Wit": return new Wit();
            case "Bruin": return new Bruin();
            case "Waldkorn": return new Waldkorn();
            case "Multi-granen": return new MultiGranen();
            default: return new Wit();
        }
    }
}
