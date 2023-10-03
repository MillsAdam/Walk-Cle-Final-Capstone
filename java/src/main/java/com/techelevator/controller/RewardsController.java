package com.techelevator.controller;

import com.techelevator.dao.RewardsDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rewards")
public class RewardsController {

    private RewardsDao rewardsDao;

    public RewardsController(RewardsDao rewardsDao) {
        this.rewardsDao = rewardsDao;
    }

    @RequestMapping(path = "/barsvisited", method = RequestMethod.GET)
    public Integer getBarCount(Principal principal) {
        String username = principal.getName();
        return rewardsDao.getAmountOfBarsVisited(username);
    }

    @RequestMapping(path = "/parksvisited", method = RequestMethod.GET)
    public Integer getParkCount(Principal principal) {
        String username = principal.getName();
        return rewardsDao.getAmountOfParksVisited(username);
    }

    @RequestMapping(path = "/stadiumsvisited", method = RequestMethod.GET)
    public Integer getStadiumCount(Principal principal) {
        String username = principal.getName();
        return rewardsDao.getAmountOfStadiumsVisited(username);
    }

    @RequestMapping(path = "/placesvisited", method = RequestMethod.GET)
    public Integer getPlacesCount(Principal principal) {
        String username = principal.getName();
        return rewardsDao.getAmountOfTotalPlacesVisited(username);
    }

    @RequestMapping(path = "/bars", method = RequestMethod.GET)
    public boolean getAllBarsReward(Principal principal) {
        String username = principal.getName();
        return rewardsDao.allBarsVisited(username);
    }

    @RequestMapping(path = "/parks", method = RequestMethod.GET)
    public boolean getAllParksReward(Principal principal) {
        String username = principal.getName();
        return rewardsDao.allParksVisited(username);
    }

    @RequestMapping(path = "/stadiums", method = RequestMethod.GET)
    public boolean getAllStadiumsReward(Principal principal) {
        String username = principal.getName();
        return rewardsDao.allStadiumsVisited(username);
    }

    @RequestMapping(path = "/places", method = RequestMethod.GET)
    public boolean getAllPlacesReward(Principal principal) {
        String username = principal.getName();
        return rewardsDao.allPlacesVisited(username);
    }

    @RequestMapping(path = "/barcheckin", method = RequestMethod.PUT)
    public Integer updateBarCheckIn(Principal principal) {
        String username = principal.getName();
        return rewardsDao.updateBarCheckIn(username);
    }

    @RequestMapping(path = "/parkcheckin", method = RequestMethod.PUT)
    public Integer updateParkCheckIn(Principal principal) {
        String username = principal.getName();
        return rewardsDao.updateParkCheckIn(username);
    }

    @RequestMapping(path = "/stadiumcheckin", method = RequestMethod.PUT)
    public Integer updateStadiumCheckIn(Principal principal) {
        String username = principal.getName();
        return rewardsDao.updateStadiumCheckIn(username);
    }
}
