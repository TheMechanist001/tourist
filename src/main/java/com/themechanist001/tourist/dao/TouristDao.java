package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Tourist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TouristDao
{
    int insertTourist(UUID touristId, Tourist tourist);

    default int insertTourist(Tourist tourist)
    {
        UUID touristId = UUID.randomUUID();
        return insertTourist(touristId, tourist);
    }

    List<Tourist> selectAllTourist();

    Optional<Tourist> selectTouristById(UUID touristId);

    int updateTouristById(UUID touristId, Tourist tourist);

    int deleteTouristById(UUID touristId);
}
