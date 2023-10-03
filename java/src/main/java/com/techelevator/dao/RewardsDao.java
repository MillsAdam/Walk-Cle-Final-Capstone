package com.techelevator.dao;
public interface RewardsDao {

    int getAmountOfBarsVisited();
    int getAmountOfParksVisited();
    int getAmountOfStadiumsVisited();
    int getAmountOfTotalPlacesVisited();
    boolean allBarsVisited();
    boolean allParksVisited();
    boolean allStadiumsVisited();
    boolean allPlacesVisited();
    Integer updateBarCheckIn();
    Integer updateParkCheckIn();
    Integer updateStadiumCheckIn();
}
