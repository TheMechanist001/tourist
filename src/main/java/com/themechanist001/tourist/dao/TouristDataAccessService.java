package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Tourist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresTourist")
public class TouristDataAccessService implements TouristDao
{
    private final JdbcTemplate jdbcTemplate;


    public TouristDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTourist(UUID touristId, Tourist tourist)
    {
        final String sql = "INSERT INTO tourist (touristId, touristName, countryOfTravel, dateDeparture, dateArrival, flightNumber, hotelName) VALUES (uuid_generate_v4(),?,?,?,?,?,?);";
        return jdbcTemplate.update(sql,tourist.getTouristName(), tourist.getCountryOfTravel(), tourist.getDateDeparture(), tourist.getDateArrival(), tourist.getFlightNumber(), tourist.getHotelName());
    }

    @Override
    public List<Tourist> selectAllTourist()
    {
        final String sql = "SELECT touristId, touristName, countryOfTravel, dateDeparture, dateArrival, flightNumber, hotelName FROM tourist";
        List<Tourist> tourists = jdbcTemplate.query(sql, (resultSet, i) ->
        {
            UUID touristId = UUID.fromString(resultSet.getString("touristId"));
            String touristName = resultSet.getString("touristName");
            String countryOfTravel = resultSet.getString("countryOfTravel");
            Date dateDeparture = resultSet.getDate("dateDeparture");
            Date dateArrival = resultSet.getDate("dateArrival");
            int flightNumber = resultSet.getInt("flightNumber");
            String hotelName = resultSet.getString("hotelName");
            return new Tourist(touristId, touristName, countryOfTravel, dateDeparture, dateArrival, flightNumber, hotelName);
        });
        return tourists;
    }

    @Override
    public Optional<Tourist> selectTouristById(UUID touristId)
    {
        final String sql = "SELECT touristId, touristName, countryOfTravel, dateDeparture, dateArrival, flightNumber, hotelName FROM tourist WHERE touristId = ?";
        Tourist tourist = jdbcTemplate.queryForObject(sql, new Object[]{touristId}, ((resultSet, i) ->
        {
            UUID id = UUID.fromString(resultSet.getString("touristId"));
            String touristName = resultSet.getString("touristName");
            String countryOfTravel = resultSet.getString("countryOfTravel");
            Date dateDeparture = resultSet.getDate("dateDeparture");
            Date dateArrival = resultSet.getDate("dateArrival");
            int flightNumber = resultSet.getInt("flightNumber");
            String hotelName = resultSet.getString("hotelName");
            return new Tourist(id, touristName, countryOfTravel, dateDeparture, dateArrival, flightNumber, hotelName);
        } ));
        return Optional.ofNullable(tourist);
    }

    @Override
    public int updateTouristById(UUID touristId, Tourist tourist)
    {
        final String sql = "UPDATE tourist SET touristName = ?, countryOfTravel = ?, dateDeparture = ?, dateArrival = ?, flightNumber = ?, hotelName = ? WHERE touristId = ?";
        return jdbcTemplate.update(sql, tourist.getTouristName(), tourist.getCountryOfTravel(), tourist.getDateDeparture(), tourist.getDateArrival(), tourist.getFlightNumber(), tourist.getHotelName(), touristId);
    }

    @Override
    public int deleteTouristById(UUID touristId)
    {
        final String sql = "DELETE FROM tourist WHERE touristId = ?";
        return jdbcTemplate.update(sql, touristId);
    }
}
