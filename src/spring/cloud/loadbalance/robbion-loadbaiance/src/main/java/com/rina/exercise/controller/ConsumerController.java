package com.rina.exercise.controller;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String lang) {
        /**
         * Here please note that: In case encounter "No instances available for COMPUTE-SERVICE" error, switch of your
         * fire wall and try to access the consumer /add api again.
         */
        // return restTemplate.getForEntity(, String.class).getBody();
        return restTemplate.exchange(
                UriComponentsBuilder.fromHttpUrl("http://compute-service/hello").build().encode().toUri(),
                // UriComponentsBuilder.fromHttpUrl("https://computelocale.cfapps.us10.hana.ondemand.com/hello").build().encode().toUri(),
                // UriComponentsBuilder.fromHttpUrl("https://api.beta.yaas.io/testeventgame/compute/v1/hello").build().encode().toUri(),
                HttpMethod.GET, getRequestEntity(null, lang), String.class)
                .getBody();

    }

    private HttpEntity<?> getRequestEntity(Object payload, String lang) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Language", new Locale(lang).toString());
        headers.set("Authorization", "Bearer 021-605db951-532f-4589-873f-de9757510d23");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(payload, headers);
    }
}
