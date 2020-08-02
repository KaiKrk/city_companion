package com.oc.p12.Controller;

import com.oc.p12.Bean.PTTrafficRequest;
import com.oc.p12.Service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicTransportController {

    @Autowired
    PublicTransportService publicTransportService;

    @PostMapping
    public void savePTTraffic(@RequestBody PTTrafficRequest ptTrafficRequest){

    }

}
