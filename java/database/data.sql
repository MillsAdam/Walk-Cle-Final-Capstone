BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO location_type (location_type_name) VALUES ('Parks');
INSERT INTO location_type (location_type_name) VALUES ('Bars');
INSERT INTO location_type (location_type_name) VALUES ('Stadiums');

INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude, location_description, location_days, location_opening_times, location_closing_times, location_img_url, location_info_url)
     VALUES ('Parks', 'Wendy Park', 41.4991564, -81.7138946, 'Lakefront tree-lined park offering fishing & boating opportunities, plus volleyball courts.', 'All Days', '6 AM', '11 PM', 'https://www.clevelandmetroparks.com/getmedia/0e6ec9e9-e7a2-4173-a853-80d1b202606f/Wendy-Park-Paddle-Access_LAN_8178.ashx?h=300&w=500&mode=crop&scale=both', 'https://www.clevelandmetroparks.com/parks/visit/parks/lakefront-reservation/wendy-park');
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Parks', 'Settlers Park', 41.4966056, -81.7013211);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Bars', 'Collision Bend Brewing Company', 41.4986853, -81.7037735);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Bars', 'Butcher and the Brewer', 41.4991465, -81.6900132);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Bars', 'Barley House', 41.5005667, -81.6991611);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Bars', 'BrewDog Cleveland Outpost', 41.492705, -81.698024);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Bars', 'Great Lakes Brewing Company', 41.4844029, -81.7045326);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Stadiums', 'Progressive Field', 41.4958921, -81.6852949);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Stadiums', 'Cleveland Browns Stadium', 41.5060535, -81.6995481);
INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude)
     VALUES ('Stadiums', 'Rocket Mortgage FieldHouse', 41.4965474, -81.6880574);

INSERT INTO rewards (username, amount_bars_visited, amount_parks_visited, amount_stadiums_visited, all_bars_visited, all_parks_visited, all_stadiums_visited, all_places_visited) VALUES ('user', 0, 0, 0, false, false, false, false);

COMMIT TRANSACTION;
