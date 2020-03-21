package com.themechanist001.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Flight
{
    private final UUID flightId;
    private final int flightNumber;
    private final String airline;
    private final String airlineContactName;

    public Flight(@JsonProperty("flightId") UUID flightId,
                  @JsonProperty("flightNumber") int flightNumber,
                  @JsonProperty("airline") String airline,
                  @JsonProperty("airlineContactName") String airlineContactName)
    {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.airlineContactName = airlineContactName;
    }

    public UUID getFlightId()
    {
        return flightId;
    }

    public int getFlightNumber()
    {
        return flightNumber;
    }

    public String getAirline()
    {
        return airline;
    }

    public String getAirlineContactName()
    {
        return airlineContactName;
    }
}
