package com.themechanist001.tourist.service;

import com.themechanist001.tourist.dao.TouristDao;
import com.themechanist001.tourist.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TouristService
{
    private final TouristDao touristDao;

    @Autowired
    public TouristService(@Qualifier("postgresTourist") TouristDao touristDao)
    {
        this.touristDao = touristDao;
    }

    public int addTourist(Tourist tourist)
    {
        return touristDao.insertTourist(tourist);
    }

    public List<Tourist> getAllTourist()
    {
        return touristDao.selectAllTourist();
    }

    public Optional<Tourist> getTouristById(UUID touristId)
    {
        return touristDao.selectTouristById(touristId);
    }

    public int updateTourist(UUID touristId, Tourist newTourist)
    {
        return touristDao.updateTouristById(touristId, newTourist);
    }

    public int deleteTourist(UUID touristId)
    {
        return touristDao.deleteTouristById(touristId);
    }
}
