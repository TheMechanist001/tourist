package com.themechanist001.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Country
{
    private final UUID countryId;
    private final String countryName;
    private final int phoneCode;
    private final String siteContactName;
    private final String siteContactAddress;

    public Country(@JsonProperty("countryId") UUID countryId,
                   @JsonProperty("countryName") String countryName,
                   @JsonProperty("phoneCode") int phoneCode,
                   @JsonProperty("siteContactName") String siteContactName,
                   @JsonProperty("siteContactAddress") String siteContactAddress)
    {
        this.countryId = countryId;
        this.countryName = countryName;
        this.phoneCode = phoneCode;
        this.siteContactName = siteContactName;
        this.siteContactAddress = siteContactAddress;
    }

    public UUID getCountryId()
    {
        return countryId;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public int getPhoneCode()
    {
        return phoneCode;
    }

    public String getSiteContactName()
    {
        return siteContactName;
    }

    public String getSiteContactAddress()
    {
        return siteContactAddress;
    }
}
