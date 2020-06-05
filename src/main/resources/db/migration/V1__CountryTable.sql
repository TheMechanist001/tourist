create TABLE country(
countryId UUID NOT NULL PRIMARY KEY,
countryName VARCHAR(100) NOT NULL,
phoneCode NUMBER(5,0),
siteContactName VARCHAR(100),
siteContactAddress VARCHAR(100)
);