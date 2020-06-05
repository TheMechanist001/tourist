create TABLE flight(
flightId UUID NOT NULL PRIMARY KEY,
flightNumber NUMBER(10,0) NOT NULL,
Airline VARCHAR(100),
AirlineContactName VARCHAR(100)
);