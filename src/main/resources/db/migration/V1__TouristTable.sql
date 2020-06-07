--tourist table
create TABLE tourist(
touristId UUID NOT NULL PRIMARY KEY,
touristName VARCHAR(100) NOT NULL,
countryOfTravel VARCHAR(100),
dateDeparture DATE,
dateArrival DATE,
flightNumber INT ,
hotelName VARCHAR(100)
);

--hotel table
create TABLE hotel(
  hotelId UUID NOT NULL PRIMARY KEY,
  hotelName VARCHAR(100) NOT NULL,
  hotelAddress VARCHAR(100),
  hotelCountry VARCHAR(100)
);

--flight table
create TABLE flight(
  flightId UUID NOT NULL PRIMARY KEY,
  flightNumber INT NOT NULL,
  Airline VARCHAR(100),
  AirlineContactName VARCHAR(100)
);

--country table
create TABLE country(
  countryId UUID NOT NULL PRIMARY KEY,
  countryName VARCHAR(100) NOT NULL,
  phoneCode INT,
  siteContactName VARCHAR(100),
  siteContactAddress VARCHAR(100)
);