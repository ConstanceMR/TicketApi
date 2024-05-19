package codo.a.codo.Ticketsapi.service;

import codo.a.codo.Ticketsapi.models.FlightDto;
import codo.a.codo.Ticketsapi.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    FlightClient flightClient;

    private final List<Ticket> tickets = new ArrayList<>();
    public List<Ticket> getAllTickets(){
        return tickets;
    }

    public Ticket addTicket (Ticket ticket, @RequestParam Long flightId){
        System.out.println(ticket.getId());
        FlightDto flight = flightClient.getFlightById(flightId).orElseThrow(() -> new RuntimeException("flightId not found"));
        ticket.setFlight(flight);
       tickets.add(ticket);
        return ticket;
    }

    public Ticket updateTicket(Ticket ticket) {

        ticket.setFlight(ticket.getFlight());
        ticket.setPassengerName(ticket.getPassengerName());
        ticket.setPassengerEmail(ticket.getPassengerEmail());
        ticket.setPassengerPassport(ticket.getPassengerPassport());
        return ticket;
    }

    public void deleteTicketById(Long id)  {
        tickets.removeIf(ticket -> ticket.getId().equals(id));
    }

}

