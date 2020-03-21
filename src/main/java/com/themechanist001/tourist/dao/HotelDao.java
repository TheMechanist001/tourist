package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Hotel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelDao
{
    int insertHotel(UUID hotelId, Hotel hotel);

    default int insertHotel(Hotel hotel)
    {
        UUID id = UUID.randomUUID();
        return insertHotel(id, hotel);
    }

    List<Hotel> selectAllHotel();

    Optional<Hotel> selectHotelById(UUID hotelId);

    int updateHotelById(UUID hotelId, Hotel hotel);

    int deleteHotelById(UUID hotelId);
}
