package com.rina.exercise.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public String hello(
            // @RequestParam String lang
            ) {
        /**
         * Here please note that: In case encounter "No instances available for COMPUTE-SERVICE" error, switch of your
         * fire wall and try to access the consumer /add api again.
         */
        // return restTemplate.getForEntity(, String.class).getBody();
        return restTemplate.exchange(
                // UriComponentsBuilder.fromHttpUrl("http://compute-service/hello").build().encode().toUri(),
                UriComponentsBuilder.fromHttpUrl("http://localhost:2223/hello").build().encode().toUri(),
                // UriComponentsBuilder.fromHttpUrl("https://computelocale.com/hello").build().encode().toUri(),
                // UriComponentsBuilder.fromHttpUrl("https://api.io/testeventgame/compute/v1/hello").build().encode().toUri(),
                // HttpMethod.GET, getRequestEntity(null, lang), String.class)
                HttpMethod.GET, null, String.class)
                .getBody();

    }

    @RequestMapping(value = "/testbc", method = RequestMethod.GET)
    public void testbc(@RequestParam String lang) {

        ObjectMapper objectMapper = new ObjectMapper();
        Object marketConfig;
        try {
            marketConfig = objectMapper.readValue(
                    new File(getFileURI("/market.json")), Object.class);
            restTemplate.exchange(
                    UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:8080/s2s/v1/config/RinaTest/Market/v1").build()
                            .encode().toUri(),
                    // UriComponentsBuilder.fromHttpUrl("https://computelocale.com/hello").build().encode().toUri(),
                    // UriComponentsBuilder.fromHttpUrl("https://api.io/testeventgame/compute/v1/hello").build().encode().toUri(),
                    HttpMethod.PUT, putRequestEntity(marketConfig, lang), String.class)
                    .getBody();
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private HttpEntity<?> putRequestEntity(Object marketConfig, String lang) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Language", new Locale(lang).toString());
        headers.set("Authorization", "Basic ****");
        headers.set("hybris-tenant", "rinatest");
        headers.set("hybris-user", "rina");

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(marketConfig, headers);
    }

    private URI getFileURI(String path) {
        final URL ruleURL = ConsumerController.class.getResource(path);
        try {
            return ruleURL.toURI();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private HttpEntity<?> getRequestEntity(Object payload, String lang) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Language", new Locale(lang).toString());
        headers.set("Authorization", "Bearer 021-605db951-532f-4589-873f-de9757510d23");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(payload, headers);
    }
}
