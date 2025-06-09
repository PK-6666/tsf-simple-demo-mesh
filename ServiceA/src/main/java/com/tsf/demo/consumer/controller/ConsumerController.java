package com.tsf.demo.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsf.demo.consumer.utils.TraceHeadersUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@RestController
public class ConsumerController {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping({"/echo-rest"})
    public String restProvider(HttpServletRequest servletRequest) {
        LOG.info("ServiceA2 echo-rest request");
        try {
            HttpHeaders headers = (new TraceHeadersUtil()).buildTraceHeaders(servletRequest);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set("x-trace-service", "ServiceA");
            HttpEntity<String> requestEntity = new HttpEntity(null, headers);
            ResponseEntity<String> response = this.restTemplate.exchange("http://ServiceB/echo" , HttpMethod.GET, requestEntity, String.class);
            return response.getBody();
        } catch (Exception ex) {
            LOG.error("access ServiceB service err", ex);
            return "访问ServiceB服务异常";
        }
    }

}