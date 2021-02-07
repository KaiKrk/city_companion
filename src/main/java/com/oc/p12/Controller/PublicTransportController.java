package com.oc.p12.Controller;

import com.oc.p12.Service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class PublicTransportController {

    @Autowired
    PublicTransportService publicTransportService;

}
