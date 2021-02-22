package be.organi.Broodjeszaak.service;

import be.organi.Broodjeszaak.domain.Bestelling;
import be.organi.Broodjeszaak.domain.repository.BestellingRepository;
import be.organi.Broodjeszaak.interfaces.Beleg;
import be.organi.Broodjeszaak.interfaces.Brood;
import be.organi.Broodjeszaak.interfaces.Saus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static be.organi.Broodjeszaak.domain.BestellingStatus.*;

@Service
public class BestellingService {

    @Autowired
    private BestellingRepository bestellingRepository;

    public Bestelling plaatsBestelling(Brood brood, Beleg beleg, Saus saus, boolean smos){
        return bestellingRepository.save(Bestelling.builder()
                .datum(LocalDate.now())
                .brood(brood)
                .beleg(beleg)
                .saus(saus)
                .prijs(berekenPrijs(brood, beleg, saus, smos))
                .status(TODO)
                .build());
    }

    public void verwerkBestelling(Long bestellingId){
        bestellingRepository.findById(bestellingId).ifPresent(bestelling -> {
            printTicket(bestelling);
            bestelling.setStatus(FINISHED);
            bestellingRepository.save(bestelling);
        });
    }

    public void annuleerBestelling(Long bestellingId){
        bestellingRepository.findById(bestellingId).ifPresent(bestelling -> {
            bestelling.setStatus(CANCELLED);
            bestellingRepository.save(bestelling);
        });

    }

    public void printTicket(Bestelling bestelling){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Rekening_Broodjeszaak_" + bestelling.getId() + ".txt"));
            bufferedWriter.append("Rekening broodjeszaak");
            bufferedWriter.newLine();
            bufferedWriter.append("=====================");
            bufferedWriter.newLine();
            bufferedWriter.append(bestelling.getDatum().toString());
            bufferedWriter.newLine();
            bufferedWriter.append("Bestelling:\t" + bestelling.getId().toString());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.append(bestelling.getBrood().getBroodsoort());
            bufferedWriter.newLine();
            bufferedWriter.append(bestelling.getBeleg().getBelegSoort());
            bufferedWriter.newLine();

            if (bestelling.getSaus() != null) {
                bufferedWriter.append(bestelling.getSaus().getSausSoort());
                bufferedWriter.newLine();
            }
            if (bestelling.isSmos()){
                bufferedWriter.append("Smos");
                bufferedWriter.newLine();
            }

            bufferedWriter.newLine();
            bufferedWriter.append("Totale prijs:\t" + bestelling.getPrijs());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Double berekenPrijs(Brood brood, Beleg beleg, Saus saus, Boolean smos){
        Double prijsSmos = smos ? 0.5 : 0;
        return brood.getBroodPrijs() + beleg.getBelegPrijs() + saus.getSausPrijs() + prijsSmos;
    }
}
