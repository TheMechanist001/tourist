package com.themechanist001.tourist.dao;

import com.themechanist001.tourist.model.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresCountry")
public class CountryDataAccessService implements CountryDao
{
    public final JdbcTemplate jdbcTemplate;

    public CountryDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCountry(UUID countryId, Country country)
    {
        final String sql = "INSERT INTO country(countryId, countryName, phoneCode, siteContactName, siteContactAddress) VALUES (uuid_generate_v4(),?,?,?,?);";
        return jdbcTemplate.update(sql, country.getCountryName(),country.getPhoneCode(),country.getSiteContactName(),country.getSiteContactAddress());
    }

    @Override
    public List<Country> selectAllCountry()
    {
        final String sql = "SELECT countryId, countryName, phoneCode, siteContactName, siteContactAddress FROM country";
        List<Country> countries = jdbcTemplate.query(sql, (resultSet, i) ->
        {
            UUID countryId = UUID.fromString(resultSet.getString("countryId"));
            String countryName = resultSet.getString("countryName");
            int phoneCode = resultSet.getInt("phoneCode");
            String siteContactName = resultSet.getString("siteContactName");
            String siteContactAddress = resultSet.getString("siteContactAddress");
           return new Country(countryId, countryName, phoneCode, siteContactName, siteContactAddress);
        });
        return countries;
    }

    @Override
    public Optional<Country> selectCountryById(UUID countryId)
    {
        final String sql = "SELECT countryId, countryName, phoneCode, siteContactName, siteContactAddress FROM country WHERE countryId = ?";
        Country country = jdbcTemplate.queryForObject(sql, new Object[]{countryId}, (resultSet, i) ->
        {
            UUID id = UUID.fromString(resultSet.getString("countryId"));
            String countryName = resultSet.getString("countryName");
            int phoneCode = resultSet.getInt("phoneCode");
            String siteContactName = resultSet.getString("siteContactName");
            String siteContactAddress = resultSet.getString("siteContactAddress");
            return new Country(id, countryName, phoneCode, siteContactName, siteContactAddress);
        });
        return Optional.ofNullable(country);
    }

    @Override
    public int updateCountryById(UUID countryId, Country country)
    {
        final String sql = "UPDATE country SET countryName =?, phoneCode =?, siteContactName = ?, siteContactAddress = ? WHERE countryId =?";
        return jdbcTemplate.update(sql, country.getCountryName(), country.getPhoneCode(), country.getSiteContactName(), country.getSiteContactAddress(), countryId);
    }

    @Override
    public int deleteCountryById(UUID countryId)
    {
        final String sql = "DELETE FROM country WHERE countryId = ?";
        return jdbcTemplate.update(sql, countryId);
    }
}
