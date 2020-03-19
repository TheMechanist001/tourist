package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Tourist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TouristDao
{
    int insertTourist(UUID touristId, Tourist touristName);

    default int insertTourist(Tourist tourist)
    {
        UUID id = UUID.randomUUID();
        return insertTourist(id, tourist);
    }

    List<Tourist> selectAllTourist();

    Optional<Tourist> selectTouristById(UUID id);

    int updateTouristById(UUID id, Tourist tourist);

    int deleteTouristById(UUID id);
}
