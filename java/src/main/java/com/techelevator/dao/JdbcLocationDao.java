package com.techelevator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.techelevator.model.Location;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.exception.DaoException;

@Component
public class JdbcLocationDao implements LocationDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcLocationDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM location";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Location location = mapRowToLocation(results);
                locations.add(location);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return locations;
    }

    @Override
    public Location getLocationById(int locationId) {
        Location location = null;
        String sql = "SELECT * FROM location WHERE location_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationId);
            if (results.next()) {
                location = mapRowToLocation(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return location;
    }

    @Override
    public Location getLocationByName(String locationName) {
        Location location = null;
        String sql = "SELECT * FROM location WHERE location_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationName);
            if (results.next()) {
                location = mapRowToLocation(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return location;
    }

    @Override
    public int getLocationIdByName(String locationName) {
        int locationId = -1;
        String sql = "SELECT location_id FROM location WHERE location_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationName);
            if (results.next()) {
                locationId = results.getInt("location_id");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return locationId;
    }

    @Override
    public List<Location> getAllLocationsByLocationTypeName (String locationTypeName) {
        String sql = "SELECT * " +
                "FROM location " +
                "WHERE location_type_name = ?;";

        List<Location> resultList = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, locationTypeName);
        while (result.next()) {
            resultList.add(mapRowToLocation(result));
        }
        return resultList;
    }

    @Override
    public Location createLocation(Location location) {
        Location newLocation = null;
        String sql = "INSERT INTO location (location_type_name, location_name, location_latitude, location_longitude, location_description, location_days, location_opening_times, location_closing_times, location_img_url, location_info_url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING location_id";

        try {
            int locationId = jdbcTemplate.queryForObject(sql, int.class,
                    location.getLocationTypeName(), location.getLocationName(),
                    location.getLocationLatitude(), location.getLocationLongitude(),
                    location.getLocationDescription(), location.getLocationDays(),
                    location.getLocationOpeningTimes(), location.getLocationClosingTimes(),
                    location.getLocationImgUrl(), location.getLocationInfoUrl());
            newLocation = getLocationById(locationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newLocation;
    }

    @Override
    public Location updateLocation(Location location) {
        Location updatedLocation = null;
        String sql = "UPDATE location SET location_type_name = ?, location_name = ?, location_latitude = ?, location_longitude = ?, location_description = ?, location_days = ?, location_opening_times = ?, location_closing_times = ?, location_img_url = ?, location_info_url = ? WHERE location_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    location.getLocationTypeName(), location.getLocationName(),
                    location.getLocationLatitude(), location.getLocationLongitude(),
                    location.getLocationDescription(), location.getLocationDays(),
                    location.getLocationOpeningTimes(), location.getLocationClosingTimes(),
                    location.getLocationImgUrl(), location.getLocationInfoUrl(),
                    location.getLocationId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            updatedLocation = getLocationById(location.getLocationId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedLocation;
    }

    @Override
    public int deleteLocationById(int locationId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM location WHERE location_id = ?";

        try {
            numberOfRows = jdbcTemplate.update(sql, locationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    private Location mapRowToLocation(SqlRowSet rs) {
        Location locations = new Location();
        locations.setLocationId(rs.getInt("location_id"));
        locations.setLocationTypeName(rs.getString("location_type_name"));
        locations.setLocationName(rs.getString("location_name"));
        locations.setLocationLatitude(rs.getDouble("location_latitude"));
        locations.setLocationLongitude(rs.getDouble("location_longitude"));
        locations.setLocationDescription(rs.getString("location_description"));
        locations.setLocationDays(Arrays.asList(rs.getString("location_days")));
        locations.setLocationOpeningTimes(Arrays.asList(rs.getString("location_opening_times")));
        locations.setLocationClosingTimes(Arrays.asList(rs.getString("location_closing_times")));
        locations.setLocationImgUrl(rs.getString("location_img_url"));
        locations.setLocationInfoUrl(rs.getString("location_info_url"));
        return locations;
    }
}
