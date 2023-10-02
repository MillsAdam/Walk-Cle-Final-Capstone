BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS locationType;
DROP TABLE IF EXISTS location;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE locationType (
    location_type_id SERIAL,
    location_type_name varchar(50) NOT NULL UNIQUE,
    CONSTRAINT PK_location_type PRIMARY KEY (location_type_id)
);

CREATE TABLE location (
    location_id SERIAL,
    location_type_id int NOT NULL,
    location_name varchar (50) NOT NULL UNIQUE,
    location_latitude double precision NOT NULL,
    location_longitude double precision NOT NULL,
    CONSTRAINT PK_location PRIMARY KEY (location_id),
    CONSTRAINT FK_location_type FOREIGN KEY (location_type_id) REFERENCES locationType (location_type_id)
);



COMMIT TRANSACTION;
