package com.techelevator.controller;

import com.techelevator.dao.GoogleMapsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GoogleServicesProxy {

    private GoogleMapsService googleMapsService = new GoogleMapsService();

    @RequestMapping(path="/test", method = RequestMethod.GET)
    public void test() {
        googleMapsService.getCandidates();
    }
}