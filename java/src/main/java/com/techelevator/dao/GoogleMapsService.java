package com.techelevator.dao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GoogleMapsService {

    public void getCandidates() {

        String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?fields=formatted_address,name,rating,place_id&input=Giant Eagle Avon Lake Ohio&inputtype=textquery&key=AIzaSyDdqqFWrwPg33CoEoUq8AacD5qyp8gb4ms";
//        String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=+16502530000&inputtype=phonenumber&key=AIzaSyDdqqFWrwPg33CoEoUq8AacD5qyp8gb4ms";
        RestTemplate template = new RestTemplate();
        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.add(HttpHeaders.USER_AGENT, "bob");
        httpheaders.add(HttpHeaders.HOST, "www.techelevator.com");
        System.out.println(url);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, new HttpEntity<String>(httpheaders), String.class);
        System.out.println(response.getBody());
    }
}
