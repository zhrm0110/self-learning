package com.rina.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        /**
         * Here please note that: In case encounter "No instances available for COMPUTE-SERVICE" error, switch of your
         * fire wall and try to access the consumer /add api again.
         */
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();

    }

}
