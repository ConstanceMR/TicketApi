package codo.a.codo.Ticketsapi.service;

import codo.a.codo.Ticketsapi.models.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "flight-api")
public interface FlightClient {

@GetMapping("/flights")
List<FlightDto> getAllFlights();

@GetMapping("/flights/{id}")
Optional<FlightDto> getFlightById(@PathVariable("id") Long productId);

}