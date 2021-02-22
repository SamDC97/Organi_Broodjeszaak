package be.organi.Broodjeszaak.resource;

import be.organi.Broodjeszaak.domain.BelegFactory;
import be.organi.Broodjeszaak.domain.Bestelling;
import be.organi.Broodjeszaak.domain.BroodFactory;
import be.organi.Broodjeszaak.domain.SausFactory;
import be.organi.Broodjeszaak.dto.PlaatsBestellingDTO;
import be.organi.Broodjeszaak.impl.Kaas;
import be.organi.Broodjeszaak.impl.Mayonaise;
import be.organi.Broodjeszaak.impl.Wit;
import be.organi.Broodjeszaak.interfaces.Saus;
import be.organi.Broodjeszaak.service.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static be.organi.Broodjeszaak.domain.BestellingStatus.TODO;

@RestController
@RequestMapping("/api/bestelling")
public class BestellingResource {

    @Autowired
    private BestellingService bestellingService;
    @Autowired
    private BroodFactory broodFactory;
    @Autowired
    private BelegFactory belegFactory;
    @Autowired
    private SausFactory sausFactory;

    @GetMapping("/printticket")
    public ResponseEntity<List<Saus>> printTicket(){
        Bestelling bestelling = Bestelling.builder()
                .id(1L)
                .datum(LocalDate.now())
                .brood(new Wit())
                .beleg(new Kaas())
                .saus(new Mayonaise())
                .smos(true)
                .prijs(2.0)
                .status(TODO)
                .build();
        bestellingService.printTicket(bestelling);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/plaats")
    public void plaatsBestelling(@RequestBody PlaatsBestellingDTO plaatsBestellingDTO){
        bestellingService.plaatsBestelling(
                broodFactory.create(plaatsBestellingDTO.getBroodsoort()),
                belegFactory.create(plaatsBestellingDTO.getBelegsoort()),
                sausFactory.create(plaatsBestellingDTO.getSaussoort()),
                plaatsBestellingDTO.isSmos());
    }

    @PostMapping("/verwerk/{bestellingId}")
    public void verwerkBestelling(@PathVariable Long bestellingId){
        bestellingService.verwerkBestelling(bestellingId);
    }

    @PostMapping("/annuleer/{bestellingId}")
    public void annuleerBestelling(@PathVariable Long bestellingId){
        bestellingService.annuleerBestelling(bestellingId);
    }
}
