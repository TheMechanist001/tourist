package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Flight;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresFlight")
public class FlightDataAccessService implements FlightDao
{
    public final JdbcTemplate jdbcTemplate;

    public FlightDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertFlight(UUID flightId, Flight flight)
    {
        final String sql = "INSERT INTO flight (flightId, flightNumber, airline, airlineContactNumber) VALUES (uuid_generate_v4(),?,?,?);";
        return jdbcTemplate.update(sql, flight.getFlightNumber(), flight.getAirline(), flight.getAirlineContactName());
    }

    @Override
    public List<Flight> selectAllFlight()
    {
        final String sql = "SELECT flightId, flightNumber, airline, airlineContactName FROM flight";
        List<Flight> flights = jdbcTemplate.query(sql, ((resultSet, i) ->
        {
            UUID flightId = UUID.fromString(resultSet.getString("flightId"));
            int flightNumber = resultSet.getInt("flightNumber");
            String airline = resultSet.getString("airline");
            String airlineContactName = resultSet.getString("airlineContactName");
            return new Flight(flightId, flightNumber, airline, airlineContactName);
        }));
        return flights;
    }

    @Override
    public Optional<Flight> selectFlightById(UUID flightId)
    {
        final String sql = "SELECT flightId, flightNumber, airline, airlineContactName FROM flight WHERE flightId = ?";
        Flight flight = jdbcTemplate.query(sql, new Object[]{flightId},resultSet ->
        {
            UUID id = UUID.fromString(resultSet.getString("flightId"));
            int flightNumber = resultSet.getInt("flightNumber");
            String airline = resultSet.getString("airline");
            String airlineContactName = resultSet.getString("airlineContactName");
            return new Flight(id, flightNumber, airline, airlineContactName);
        });
        return Optional.ofNullable(flight);
    }

    @Override
    public int updateFlightById(UUID flightId, Flight flight)
    {
        final String sql = "UPDATE flight SET flightNumber = ?, airline = ?, airlineContactName = ? WHERE flightId = ?";
        return jdbcTemplate.update(sql, flightId);
    }

    @Override
    public int deleteFlightById(UUID flightId)
    {
        final String sql = "DELETE FROM flight WHERE flightId = ?";
        return jdbcTemplate.update(sql, flightId);
    }
}
