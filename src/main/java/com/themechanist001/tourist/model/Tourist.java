package com.themechanist001.tourist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Tourist
{
    private final UUID touristId;
    @NotBlank
    private final String touristName;
    private final String countryOfTravel;
    private final Date dateDeparture;
    private final Date dateArrival;
    private final int flightNumber;
    private final String hotelName;

    public Tourist(@JsonProperty("id") UUID touristId,
                   @JsonProperty("touristName") @NotBlank String touristName,
                   @JsonProperty("countryOfTravel") String countryOfTravel,
                   @JsonProperty("dateDeparture") Date dateDeparture,
                   @JsonProperty("dateArrival") Date dateArrival,
                   @JsonProperty("flightNumber") int flightNumber,
                   @JsonProperty("hotelName") String hotelName)
    {
        this.touristId = touristId;
        this.touristName = touristName;
        this.countryOfTravel = countryOfTravel;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.flightNumber = flightNumber;
        this.hotelName = hotelName;
    }

    public final UUID getTouristId()
    {
        return touristId;
    }

    public String getTouristName()
    {
        return touristName;
    }

    public String getCountryOfTravel()
    {
        return countryOfTravel;
    }

    public Date getDateDeparture()
    {
        return dateDeparture;
    }

    public Date getDateArrival()
    {
        return dateArrival;
    }

    public int getFlightNumber()
    {
        return flightNumber;
    }

    public String getHotelName()
    {
        return hotelName;
    }
}