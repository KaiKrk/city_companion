package com.oc.p12.Controller;

import com.oc.p12.Service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicTransportController {

    @Autowired
    PublicTransportService publicTransportService;


}
