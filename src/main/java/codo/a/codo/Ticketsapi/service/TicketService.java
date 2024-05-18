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
        System.out.println(flightId);
        FlightDto flight = flightClient.getFlightById(flightId).orElseThrow(() -> new RuntimeException("flightId not found"));
        ticket.setFlight(flight);
       tickets.add(ticket);
        return ticket;
    }

    public Ticket updateTicket(Ticket TicketUpdate) {
        Long TicketId = TicketUpdate.getId();
        Ticket Ticket =tickets.stream()
                .filter(ticket -> ticket.getId().equals(TicketId))
                .findFirst().orElseThrow(()-> new RuntimeException("TicketId not found"));
        Ticket.setId(TicketId);
        Ticket.setFlight(TicketUpdate.getFlight());
        Ticket.setPassengerName(TicketUpdate.getPassengerName());
        Ticket.setPassengerEmail(TicketUpdate.getPassengerEmail());
        Ticket.setPassengerPassport(TicketUpdate.getPassengerPassport());
        return Ticket;
    }

    public void deleteTicket(Long ticketId)  {
        tickets.removeIf(ticket -> ticket.getId().equals(ticketId));
    }

}

