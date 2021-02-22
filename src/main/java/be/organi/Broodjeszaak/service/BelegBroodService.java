package be.organi.Broodjeszaak.service;

import be.organi.Broodjeszaak.impl.*;
import be.organi.Broodjeszaak.interfaces.Beleg;
import be.organi.Broodjeszaak.interfaces.Brood;
import be.organi.Broodjeszaak.interfaces.Saus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BelegBroodService {

    public List<Brood> getAlleBroodsoorten(){
        List<Brood> broodsoorten = new ArrayList<>();
        broodsoorten.add(new Wit());
        broodsoorten.add(new Bruin());
        broodsoorten.add(new Waldkorn());
        broodsoorten.add(new MultiGranen());
        return broodsoorten;
    }

    public List<Beleg> getAlleBeleggen(){
        List<Beleg> belegsoorten = new ArrayList<>();
        belegsoorten.add(new Kaas());
        belegsoorten.add(new Ham());
        belegsoorten.add(new KipCurry());
        belegsoorten.add(new Americain());
        belegsoorten.add(new Krabsla());
        belegsoorten.add(new GebakkenKip());
        return belegsoorten;
    }

    public List<Saus> getAlleSauzen(){
        List<Saus> sausSoorten = new ArrayList<>();
        sausSoorten.add(new Mayonaise());
        sausSoorten.add(new Ketchup());
        sausSoorten.add(new Pepersaus());
        sausSoorten.add(new Andalouse());
        sausSoorten.add(new Cocktail());
        return sausSoorten;
    }

}
