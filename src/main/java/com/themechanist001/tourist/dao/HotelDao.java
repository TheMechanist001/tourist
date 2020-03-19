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

    Optional<Hotel> selectHotelById(UUID id);

    int updateHotelById(UUID id, Hotel hotel);

    int deleteHotelById(UUID id);
}
