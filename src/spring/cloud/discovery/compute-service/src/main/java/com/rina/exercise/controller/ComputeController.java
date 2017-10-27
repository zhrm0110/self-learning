package com.rina.exercise.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        String serviceId = registration.getServiceId();
        List<ServiceInstance> instances = client.getInstances(serviceId);
        if (instances.size() > 0) {
            ServiceInstance instance = instances.get(0);
            Integer r = a + b;
            logger.info("/add, host: " + instance.getHost()
                    + ", service_id: " + instance.getServiceId()
                    + ", result: " + r);
            return r;
        }
        return null;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Locale locale) {
        // Locale locale = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
        // .getLocale();
        if (locale.equals(Locale.GERMAN)) {
            logger.info(locale);
            return "Hello German";
        } else if (locale.equals(Locale.ENGLISH)) {
            logger.info(locale);
            return "Hello English";
        } else if (locale.equals(Locale.CHINESE)) {
            logger.info(locale);
            return "Hello China";
        } else if (locale.equals(Locale.JAPANESE)) {
            logger.info(locale);
            return "Hello Japan";
        } else {
            logger.info(locale);
            return "Hello Default";
        }
    }
}
