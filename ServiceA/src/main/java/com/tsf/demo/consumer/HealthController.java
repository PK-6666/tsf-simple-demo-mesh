package com.tsf.demo.consumer;

import com.alibaba.fastjson.JSONObject;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class HealthController {
    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    @GetMapping({"/health"})
    public JSONObject health() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "UP");
        return jsonObject;
    }
}
