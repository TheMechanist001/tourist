package com.themechanist001.tourist.service;

import com.themechanist001.tourist.dao.FlightDao;
import com.themechanist001.tourist.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightService
{
    private final FlightDao flightDao;

    @Autowired
    public FlightService(@Qualifier("postgresFlight") FlightDao flightDao)
    {
        this.flightDao = flightDao;
    }

    public int addFlight(Flight flight)
    {
        return flightDao.insertFlight(flight);
    }

    public List<Flight> getAllFlight()
    {
        return flightDao.selectAllFlight();
    }

    public Optional<Flight> getFlightById(UUID flightId)
    {
        return flightDao.selectFlightById(flightId);
    }

    public int updateFlight(UUID flightId, Flight newFlight)
    {
        return flightDao.updateFlightById(flightId, newFlight);
    }

    public int deleteFlight(UUID flightId)
    {
        return flightDao.deleteFlightById(flightId);
    }
}
