package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Flight;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightDao
{
    int insertFlight(UUID id, Flight flight);

    default int insertFlight(Flight flight)
    {
        UUID id = UUID.randomUUID();
        return insertFlight(id, flight);
    }

    List<Flight> selectAllFlight();

    Optional<Flight> selectFlightById(UUID id);

    int updateFlightById(UUID id, Flight flight);

    int deleteFlightById(UUID id);
}
