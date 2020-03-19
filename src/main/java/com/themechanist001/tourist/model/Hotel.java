package com.themechanist001.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Hotel
{
    private final UUID hotelId;
    private final String hotelName;
    private final String hotelAddress;
    private final String hotelCountry;

    public Hotel(@JsonProperty("hotelId") UUID hotelId,
                 @JsonProperty("hotelName") String hotelName,
                 @JsonProperty("hotelAddress") String hotelAddress,
                 @JsonProperty("hotelCountry") String hotelCountry)
    {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelCountry = hotelCountry;
    }

    public UUID getHotelId()
    {
        return hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public String getHotelAddress()
    {
        return hotelAddress;
    }

    public String getHotelCountry()
    {
        return hotelCountry;
    }
}
