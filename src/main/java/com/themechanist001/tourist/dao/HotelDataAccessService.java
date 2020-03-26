package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresHotel")
public class HotelDataAccessService implements HotelDao
{
    public final JdbcTemplate jdbcTemplate;

    public HotelDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertHotel(UUID hotelId, Hotel hotel)
    {
        final String sql = "INSERT INTO hotel ( hotelId, hotelName, hotelAddress, hotelCountry) VALUES (uuid_generate_v4(),?,?,?);";
        return jdbcTemplate.update(sql, hotel.getHotelName(), hotel.getHotelAddress(), hotel.getHotelCountry());
    }

    @Override
    public List<Hotel> selectAllHotel()
    {
        final String sql ="SELECT hotelId, hotelName, hotelAddress, hotelCountry FROM hotel";
        List<Hotel> hotels = jdbcTemplate.query(sql, (resultSet, i) ->
        {
            UUID hotelId = UUID.fromString(resultSet.getString("hotelId"));
            String hotelName = resultSet.getString("hotelName");
            String hotelAddress = resultSet.getString("hotelAddress");
            String hotelCountry = resultSet.getString("hotelCountry");
            return new Hotel(hotelId, hotelName, hotelAddress, hotelCountry);
        });
        return hotels;
    }

    @Override
    public Optional<Hotel> selectHotelById(UUID hotelId)
    {
        final String sql = "SELECT hotelId, hotelName, hotelAddress, hotelCountry FROM hotel WHERE hotelId = ?";
        Hotel hotel = jdbcTemplate.queryForObject(sql, new Object[]{hotelId}, (resultSet, i) ->
        {
            UUID id = UUID.fromString((resultSet.getString("hotelId")));
            String hotelName = resultSet.getString("hotelName");
            String hotelAddress = resultSet.getString("hotelAddress");
            String hotelCountry = resultSet.getString("hotelCountry");
            return new Hotel(id, hotelName, hotelAddress, hotelCountry);
        });
        return Optional.ofNullable(hotel);
    }

    @Override
    public int updateHotelById(UUID hotelId, Hotel hotel)
    {
        final String sql = "UPDATE hotel SET hotelName = ?, hotelAddress = ?, hotelCountry = ? WHERE hotelId = ?";
        return jdbcTemplate.update(sql, hotel.getHotelName(), hotel.getHotelAddress(), hotel.getHotelCountry(), hotelId);
    }

    @Override
    public int deleteHotelById(UUID hotelId)
    {
        final String sql = "DELETE FROM hotel WHERE hotelId = ?";
        return jdbcTemplate.update(sql, hotelId);
    }
}
