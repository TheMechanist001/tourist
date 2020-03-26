create TABLE tourist(
touristId UUID NOT NULL PRIMARY KEY,
touristName VARCHAR(100) NOT NULL,
countryOfTravel VARCHAR(100),
dateDeparture DATE,
dateArrival DATE
flightNumber NUMBER(10,0),
hotelName VARCHAR(100)
);

create TABLE hotel(
hotelId UUID NOT NULL PRIMARY KEY,
hotelName VARCHAR(100) NOT NULL,
hotelAddress VARCHAR(100),
hotelCountry VARCHAR(100)
);

create TABLE country(
countryId UUID NOT NULL PRIMARY KEY,
countryName VARCHAR(100) NOT NULL,
phoneCode NUMBER(5,0),
siteContactName VARCHAR(100),
siteContactAddress VARCHAR(100)
);

create TABLE flight(
flightId UUID NOT NULL PRIMARY KEY,
flightNumber NUMBER(10,0) NOT NULL,
Airline VARCHAR(100),
AirlineContactName VARCHAR(100)
);