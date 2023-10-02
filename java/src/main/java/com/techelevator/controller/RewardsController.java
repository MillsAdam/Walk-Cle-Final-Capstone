package com.techelevator.controller;

import com.techelevator.dao.RewardsDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rewards")
public class RewardsController {

    private RewardsDao rewardsDao;
    public RewardsController(RewardsDao rewardsDao) {
        this.rewardsDao = rewardsDao;
    }

    @RequestMapping(path="/bars", method = RequestMethod.GET)
    public Integer getBarCount() {
        return rewardsDao.getAmountOfBarsVisited();
    }

    @RequestMapping(path="/parks", method = RequestMethod.GET)
    public Integer getParkCount() {
        return rewardsDao.getAmountOfParksVisited();
    }

    @RequestMapping(path="/stadiums", method = RequestMethod.GET)
    public Integer getStadiumCount() {
        return rewardsDao.getAmountOfStadiumsVisited();
    }



}
