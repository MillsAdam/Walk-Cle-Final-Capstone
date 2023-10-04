package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CheckInRecord;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCheckInRecordDao implements CheckInRecordDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCheckInRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CheckInRecord> getCheckInRecords() {

        List<CheckInRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM checkins";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                CheckInRecord checkInRecord = mapRowToCheckInRecord(results);
                records.add(checkInRecord);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return records;
    }

    private CheckInRecord mapRowToCheckInRecord(SqlRowSet rs) {
        CheckInRecord checkInRecord = new CheckInRecord();
        checkInRecord.setCheckInId(rs.getInt("checkin_id"));
        checkInRecord.setUsername(rs.getString("username"));
        checkInRecord.setLocationId(rs.getInt("location_id"));
        checkInRecord.setCheckedIn(rs.getBoolean("checked_in"));
        checkInRecord.setTimestamp(rs.getTimestamp("timestamp"));

        return checkInRecord;
    }

}
