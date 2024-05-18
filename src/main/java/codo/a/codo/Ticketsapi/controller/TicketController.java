package codo.a.codo.Ticketsapi.controller;

import codo.a.codo.Ticketsapi.models.FlightDto;
import codo.a.codo.Ticketsapi.models.Ticket;
import codo.a.codo.Ticketsapi.service.FlightClient;
import codo.a.codo.Ticketsapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    FlightClient flightClient;


    @GetMapping("")
        private List<Ticket> getAllTickets(){
            return ticketService.getAllTickets();
        }
        @GetMapping("/flights")
        public List<FlightDto> getAllFlights(){
            return flightClient.getAllFlights();

        }

        @GetMapping("/flights/{id}")
        public Optional<Optional<FlightDto>> flightById(@PathVariable Long id) {
            return Optional.ofNullable(flightClient.getFlightById(id));
        }

        @PostMapping("/add")
        public Ticket addTicket(@RequestBody Ticket ticket, @RequestParam Long flightId) {
            return ticketService.addTicket(ticket, flightId);
        }

        @PutMapping("/update")
        public Ticket update(@RequestBody Ticket ticket) {
            return ticketService.updateTicket(ticket);
        }

        @DeleteMapping("delete/{id}")
        public void delete(@PathVariable Long id) {
            ticketService.deleteTicket(id);
        }
    }

