package com.techelevator.model;

import java.util.List;

public class Location {
    private int locationId;
    private String locationTypeName;
    private String locationName;
    private double locationLatitude;
    private double locationLongitude;
    private String locationDescription;
    private List<String> locationDays;
    private List<String> locationOpeningTimes;
    private List<String> locationClosingTimes;
    private String locationImgUrl;
    private String locationInfoUrl;


    public Location() {}

    public Location(int locationId, String locationTypeName, String locationName, double locationLatitude, double locationLongitude, String locationDescription, List<String> locationDays, List<String> locationOpeningTimes, List<String> locationClosingTimes, String locationImgUrl, String locationInfoUrl) {
        this.locationId = locationId;
        this.locationTypeName = locationTypeName;
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationDescription = locationDescription;
        this.locationDays = locationDays;
        this.locationOpeningTimes = locationOpeningTimes;
        this.locationClosingTimes = locationClosingTimes;
        this.locationImgUrl = locationImgUrl;
        this.locationInfoUrl = locationInfoUrl;
    }


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public List<String> getLocationDays() {
        return locationDays;
    }

    public void setLocationDays(List<String> locationDays) {
        this.locationDays = locationDays;
    }

    public List<String> getLocationOpeningTimes() {
        return locationOpeningTimes;
    }

    public void setLocationOpeningTimes(List<String> locationOpeningTimes) {
        this.locationOpeningTimes = locationOpeningTimes;
    }

    public List<String> getLocationClosingTimes() {
        return locationClosingTimes;
    }

    public void setLocationClosingTimes(List<String> locationClosingTimes) {
        this.locationClosingTimes = locationClosingTimes;
    }

    public String getLocationImgUrl() {
        return locationImgUrl;
    }

    public void setLocationImgUrl(String locationImgUrl) {
        this.locationImgUrl = locationImgUrl;
    }

    public String getLocationInfoUrl() {
        return locationInfoUrl;
    }

    public void setLocationInfoUrl(String locationInfoUrl) {
        this.locationInfoUrl = locationInfoUrl;
    }


    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationTypeName='" + locationTypeName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationLatitude=" + locationLatitude +
                ", locationLongitude=" + locationLongitude +
                ", locationDescription='" + locationDescription + '\'' +
                ", locationDays='" + locationDays +
                ", locationOpeningTimes=" + locationOpeningTimes +
                ", locationClosingTimes=" + locationClosingTimes +
                ", locationImgUrl='" + locationImgUrl + '\'' +
                ", locationInfoUrl='" + locationInfoUrl + '\'' +
                '}';
    }
}
