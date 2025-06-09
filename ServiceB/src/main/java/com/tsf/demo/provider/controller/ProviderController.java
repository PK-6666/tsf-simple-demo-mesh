package com.tsf.demo.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class);

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        LOG.info("ServiceB2 echo request");
        return "ServiceB2";
    }

}