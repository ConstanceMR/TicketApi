package codo.a.codo.Ticketsapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class FlightDto {

    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double convertedPrice;
    private String frecuency;

}