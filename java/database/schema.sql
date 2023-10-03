BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS location_type;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS rewards;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE location_type (
    location_type_id SERIAL,
    location_type_name varchar(50) NOT NULL UNIQUE,
    CONSTRAINT PK_location_type PRIMARY KEY (location_type_id)
);

CREATE TABLE location (
    location_id SERIAL,
    location_type_name varchar (50) NOT NULL,
    location_name varchar (50) NOT NULL UNIQUE,
    location_latitude double precision NOT NULL,
    location_longitude double precision NOT NULL,
    location_description varchar (200),
    location_days varchar (200),
    location_opening_times varchar (200),
    location_closing_times varchar (200),
    location_img_url varchar (200),
    location_info_url varchar (200),
    CONSTRAINT PK_location PRIMARY KEY (location_id),
    CONSTRAINT FK_location_type_name FOREIGN KEY (location_type_name) REFERENCES location_type (location_type_name)
);

CREATE TABLE rewards (
    rewards_id SERIAL,
    username varchar(50) NOT NULL UNIQUE,
    amount_bars_visited int NOT NULL,
    amount_parks_visited int NOT NULL,
    amount_stadiums_visited int NOT NULL,
    all_bars_visited boolean DEFAULT false,
    all_parks_visited boolean DEFAULT false,
    all_stadiums_visited boolean DEFAULT false,
    all_places_visited boolean DEFAULT false,
    CONSTRAINT PK_rewards_id PRIMARY KEY (rewards_id),
    CONSTRAINT FK_username FOREIGN KEY (username) REFERENCES users (username)
);





COMMIT TRANSACTION;
