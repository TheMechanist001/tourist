package com.themechanist001.tourist.service;

import com.themechanist001.tourist.dao.CountryDao;
import com.themechanist001.tourist.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService
{
    private final CountryDao countryDao;

    @Autowired
    public CountryService(@Qualifier("postgresCountry") CountryDao countryDao)
    {
        this.countryDao = countryDao;
    }

    public int addCountry(Country country)
    {
        return countryDao.insertCountry(country);
    }

    public List<Country> getAllCountry()
    {
        return  countryDao.selectAllCountry();
    }

    public Optional<Country> getCountryById(UUID countryId)
    {
        return  countryDao.selectCountryById(countryId);
    }

    public int updateCountry(UUID countryId, Country newCountry)
    {
        return countryDao.updateCountryById(countryId, newCountry);
    }

    public int deleteCountry(UUID countryId)
    {
        return countryDao.deleteCountryById(countryId);
    }
}
