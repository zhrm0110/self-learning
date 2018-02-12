package com.rina.exercise.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MultiCurrencyController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List getContacts() {
        /**
         * Here please note that: In case encounter "No instances available for COMPUTE-SERVICE" error, switch of your
         * fire wall and try to access the consumer /add api again.
         */
        HttpHeaders headers = new HttpHeaders();
        headers.set("hybris-tenant", "tenantIT");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map> result = new ArrayList<>();
        restTemplate
                .exchange("http://business-partner/public/v2/contacts", HttpMethod.GET, entity, List.class).getBody()
                .forEach(rebo -> {
                    result.add(objectMapper.convertValue(rebo, Map.class));
                });
        return result;
    }

    @RequestMapping(value = "/contacts/2720194590", method = RequestMethod.PUT)
    public ResponseEntity<Void> pubContact() {
        String timestemp = String.valueOf(new Date().getTime());
        System.out.println(timestemp);
        HttpHeaders headers = new HttpHeaders();
        headers.set("hybris-tenant", "tenantIT");
        headers.set("externalSystemId", timestemp);
        headers.add("hybris-user", "rina");
        Map<String, String> externalref = new HashMap<>();
        externalref.put("externalSystemId", timestemp);
        externalref.put("externalIdTypeCode", "201");
        externalref.put("externalId", "123456789");
        List<Map<String, String>> payload = new ArrayList<>();
        payload.add(externalref);
        HttpEntity<List> entity = new HttpEntity<List>(payload, headers);
        return restTemplate.exchange("http://business-partner/public/v2/contacts/2720194590/externalObjectReference",
                HttpMethod.PUT, entity,
                Void.class);
    }

    @RequestMapping(value = "/contacts/same", method = RequestMethod.PUT)
    public ResponseEntity<Void> pubContactSame() {
        // String timestemp = String.valueOf(new Date().getTime());
        // System.out.println(timestemp);
        HttpHeaders headers = new HttpHeaders();
        headers.set("hybris-tenant", "tenantIT");
        headers.set("externalSystemId", "rina");
        headers.add("hybris-user", "rina");
        Map<String, String> externalref = new HashMap<>();
        externalref.put("externalSystemId", "rina");
        externalref.put("externalIdTypeCode", "201");
        externalref.put("externalId", "123456789");
        List<Map<String, String>> payload = new ArrayList<>();
        payload.add(externalref);
        HttpEntity<List> entity = new HttpEntity<List>(payload, headers);
        return restTemplate.exchange("http://business-partner/public/v2/contacts/2720194590/externalObjectReference",
                HttpMethod.PUT, entity,
                Void.class);
    }
}
