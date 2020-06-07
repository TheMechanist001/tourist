package com.themechanist001.tourist.api;

import com.themechanist001.tourist.model.Flight;
import com.themechanist001.tourist.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/flight")
@RestController
public class FlightController
{
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService)
    {
        this.flightService = flightService;
    }

    @PostMapping
    public void addFlight(@Valid @NotNull @RequestBody Flight flight)
    {
        flightService.addFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlight()
    {
        return flightService.getAllFlight();
    }

    @GetMapping(path = "{flightId}")
    public Flight getFlightById(@PathVariable("flightId") UUID flightId)
    {
        return flightService.getFlightById(flightId).orElse(null);
    }

    @PutMapping(path = "{flightId}")
    public void updateFlightById(@PathVariable("flightId") UUID flightId, @Valid @NotNull @RequestBody Flight flightToUpdate)
    {
        flightService.updateFlight(flightId, flightToUpdate);
    }

    @DeleteMapping(path = "{flightId}")
    public void deleteFlightById(@PathVariable("flightId") UUID flightId)
    {
        flightService.deleteFlight(flightId);
    }
}
