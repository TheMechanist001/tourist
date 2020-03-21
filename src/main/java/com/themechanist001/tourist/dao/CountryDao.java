package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryDao
{
    int insertCountry(UUID countryId, Country country);

    default int insertCountry(Country country)
    {
        UUID id = UUID.randomUUID();
        return insertCountry(id, country);
    }

    List<Country> selectAllCountry();

    Optional<Country> selectCountryById(UUID countryId);

    int updateCountryById(UUID countryId, Country country);

    int deleteCountryById(UUID countryId);
}
