package be.organi.Broodjeszaak.resource;

import be.organi.Broodjeszaak.interfaces.Beleg;
import be.organi.Broodjeszaak.interfaces.Brood;
import be.organi.Broodjeszaak.interfaces.Saus;
import be.organi.Broodjeszaak.service.BelegBroodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brood")
public class BelegBroodResource {

    @Autowired
    private BelegBroodService belegBroodService;

    @GetMapping("/broodsoorten")
    public ResponseEntity<List<Brood>> getAlleBroodsoorten(){
        List<Brood> broodsoorten = belegBroodService.getAlleBroodsoorten();
        return new ResponseEntity<>(broodsoorten, HttpStatus.OK);
    }

    @GetMapping("/belegsoorten")
    public ResponseEntity<List<Beleg>> getAlleBelegsoorten(){
        List<Beleg> belegsoorten = belegBroodService.getAlleBeleggen();
        return new ResponseEntity<>(belegsoorten, HttpStatus.OK);
    }

    @GetMapping("/saussoorten")
    public ResponseEntity<List<Saus>> getAlleSausSoorten(){
        List<Saus> saussoorten = belegBroodService.getAlleSauzen();
        return new ResponseEntity<>(saussoorten, HttpStatus.OK);
    }

}
