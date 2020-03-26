package com.themechanist001.tourist.service;

import com.themechanist001.tourist.dao.HotelDao;
import com.themechanist001.tourist.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService
{
    private final HotelDao hotelDao;

    @Autowired
    public HotelService(@Qualifier("postgresHotel") HotelDao hotelDao)
    {
        this.hotelDao = hotelDao;
    }

    public int addHotel(Hotel hotel)
    {
        return hotelDao.insertHotel(hotel);
    }

    public List<Hotel> getAllHotel()
    {
        return hotelDao.selectAllHotel();
    }

    public Optional<Hotel> getHotelById(UUID hotelId)
    {
        return hotelDao.selectHotelById(hotelId);
    }

    public int updateHotel(UUID hotelId, Hotel newHotel)
    {
        return hotelDao.updateHotelById(hotelId, newHotel);
    }

    public int deleteHotel(UUID hotelId)
    {
        return hotelDao.deleteHotelById(hotelId);
    }
}
