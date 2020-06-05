create TABLE tourist(
touristId UUID NOT NULL PRIMARY KEY,
touristName VARCHAR(100) NOT NULL,
countryOfTravel VARCHAR(100),
dateDeparture DATE,
dateArrival DATE
flightNumber NUMBER(10,0),
hotelName VARCHAR(100)
);