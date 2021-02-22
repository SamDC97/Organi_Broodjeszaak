package be.organi.Broodjeszaak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaatsBestellingDTO {
    private String broodsoort;
    private String belegsoort;
    private String saussoort;
    private boolean smos;
}
