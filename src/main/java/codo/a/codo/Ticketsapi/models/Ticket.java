package codo.a.codo.Ticketsapi.models;



import lombok.Data;

@Data
public class Ticket {
    private Long id;
    private FlightDto flight;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;


    public Ticket(Long id, FlightDto flight, String passengerName, String passengerEmail, String passengerPassport) {
        this.id = id;
        this.flight = flight;
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.passengerPassport = passengerPassport;
    }
}

